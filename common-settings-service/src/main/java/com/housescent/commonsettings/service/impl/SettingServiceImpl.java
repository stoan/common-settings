package com.housescent.commonsettings.service.impl;

import com.housescent.commonsettings.persistence.entities.Application;
import com.housescent.commonsettings.persistence.entities.Property;
import com.housescent.commonsettings.persistence.repositories.ApplicationRepository;
import com.housescent.commonsettings.persistence.repositories.PropertyRepository;
import com.housescent.commonsettings.service.exception.DuplicateSettingFoundException;
import com.housescent.commonsettings.service.exception.SettingNotFoundException;
import com.housescent.commonsettings.service.local.LocalSettingService;
import com.housescent.commonsettings.service.remote.SettingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Siya Sosibo on 21/02/2017.
 */
@Service
public class SettingServiceImpl implements SettingService, LocalSettingService {

    public static final String PROPERTY_NOT_FOUND = "Property not found";
    public static final String APPLICATION_NOT_FOUND = "Application not found";
    public static final String APPLICATION_ALREADY_EXISTS = "Application already exists";
    public static final String PROPERTY_ALREADY_EXIST = "Property already exist";

    private PropertyRepository propertyRepository;
    private ApplicationRepository applicationRepository;

    public SettingServiceImpl(PropertyRepository propertyRepository, ApplicationRepository applicationRepository) {
        this.propertyRepository = propertyRepository;
        this.applicationRepository = applicationRepository;
    }

    @Override
    public String getPropertyValue(String applicationName, String key) {
        Property property = propertyRepository.findByApplication_applicationNameAndKeyIgnoreCase(applicationName, key);

        if (property != null) {
            return property.getValue();
        } else {
            throw new SettingNotFoundException(PROPERTY_NOT_FOUND);
        }
    }

    @Override
    public Map<String, String> getPropertiesForApplicationAsMap(String applicationName) {
        List<Property> props = propertyRepository.findByApplication_applicationNameIgnoreCase(applicationName);

        Map<String, String> properties = null;

        if (props != null) {
            properties = new HashMap<>();
            for (Property prop : props) {
                properties.put(prop.getKey(), prop.getValue());
            }
        }
        return properties;
    }

    @Override
    public List<Property> getPropertiesForApplication(String applicationName) {
        return propertyRepository.findByApplication_applicationNameIgnoreCase(applicationName);
    }

    @Override
    public Application getApplication(String applicationName) {
        Application application = applicationRepository.findByApplicationNameIgnoreCase(applicationName);

        if (application != null) {
            return application;
        } else {
            throw new SettingNotFoundException(APPLICATION_NOT_FOUND);
        }
    }

    @Override
    @Transactional
    public boolean addProperty(String applicationName, String key, String value) {
        Application application = applicationRepository.findByApplicationNameIgnoreCase(applicationName);

        if (application == null) {
            throw new SettingNotFoundException(APPLICATION_NOT_FOUND);
        }

        Property property = propertyRepository.findByApplication_applicationNameAndKeyIgnoreCase(applicationName, key);

        if (property != null) {
            throw new DuplicateSettingFoundException(PROPERTY_ALREADY_EXIST);
        }

        property = propertyRepository.save(new Property(key, value, application));

        return property.getId() > 0;
    }

    @Override
    @Transactional
    public void updateProperty(String applicationName, String key, String value) {
        Property property = propertyRepository.findByApplication_applicationNameAndKeyIgnoreCase(applicationName, key);
        if (property == null) {
            throw new SettingNotFoundException(PROPERTY_NOT_FOUND);
        }
        property.setValue(value);
    }

    @Override
    public void deleteProperty(String applicationName, String key) {
        Property property = propertyRepository.findByApplication_applicationNameAndKeyIgnoreCase(applicationName, key);
        if (property == null) {
            throw new SettingNotFoundException(PROPERTY_NOT_FOUND);
        }

        propertyRepository.delete(property);
    }

    @Override
    @Transactional
    public boolean addApplication(String applicationName, String description) {
        Application application = applicationRepository.findByApplicationNameIgnoreCase(applicationName);
        if (application != null) {
            throw new DuplicateSettingFoundException(APPLICATION_ALREADY_EXISTS);
        }

        application = applicationRepository.save(new Application(applicationName, description));

        return application.getId() > 0;
    }

    @Override
    public List<Application> getApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public void deleteApplication(String applicationName) {
        Application application = applicationRepository.findByApplicationNameIgnoreCase(applicationName);
        if (application == null) {
            throw new SettingNotFoundException(APPLICATION_NOT_FOUND);
        }

        applicationRepository.delete(application);
    }

    @Override
    @Transactional
    public void updateApplication(String applicationName, String description) {
        Application application = applicationRepository.findByApplicationNameIgnoreCase(applicationName);

        if (application == null) {
            throw new SettingNotFoundException(APPLICATION_NOT_FOUND);
        }

        application.setDescription(description);
    }
}

package com.housescent.commonsettings.service.local;

import com.housescent.commonsettings.persistence.entities.Application;
import com.housescent.commonsettings.persistence.entities.Property;
import com.housescent.commonsettings.service.remote.SettingService;

import java.util.List;

/**
 * Created by Siya Sosibo on 21/02/2017.
 */
public interface LocalSettingService extends SettingService {

    List<Property> getPropertiesForApplication(String applicationName);

    boolean addProperty(String applicationName, String key, String value);

    void updateProperty(String applicationName, String key, String value);

    void deleteProperty(String applicationName, String key);

    boolean addApplication(String applicationName, String description);

    List<Application> getApplications();

    void deleteApplication(String applicationName);

    void updateApplication(String applicationName, String description);
}

package com.housescent.commonsettings.web.controller;

import com.housescent.commonsettings.persistence.entities.Application;
import com.housescent.commonsettings.persistence.entities.Property;
import com.housescent.commonsettings.service.local.LocalSettingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Siya Sosibo on 13/03/2017.
 */
@Controller
public class ServiceController {

    private LocalSettingService localSettingService;

    public ServiceController(LocalSettingService localSettingService) {
        this.localSettingService = localSettingService;
    }

    @RequestMapping(value = "fetchPropertiesForApplication", method = RequestMethod.GET)
    public List<Property> getPropertiesForApplication(@RequestParam(value = "applicationName") String applicationName) {
        return localSettingService.getPropertiesForApplication(applicationName);
    }

    @RequestMapping(value = "saveProperty", method = RequestMethod.POST)
    public boolean addProperty(@RequestParam(value = "applicationName") String applicationName, @RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        return localSettingService.addProperty(applicationName, key, value);
    }

    @RequestMapping(value = "updateProperty", method = RequestMethod.POST)
    public void updateProperty(@RequestParam(value = "applicationName") String applicationName, @RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        localSettingService.updateProperty(applicationName, key, value);
    }

    @RequestMapping(value = "deleteProperty", method = RequestMethod.DELETE)
    public void deleteProperty(@RequestParam(value = "applicationName") String applicationName, @RequestParam(value = "key") String key) {
        localSettingService.deleteProperty(applicationName, key);
    }

    @RequestMapping(value = "saveApplication", method = RequestMethod.POST)
    public boolean addApplication(@RequestParam(value = "applicationName") String applicationName, @RequestParam(value = "description") String description) {
        return localSettingService.addApplication(applicationName, description);
    }

    @RequestMapping(value = "fetchApplications", method = RequestMethod.GET)
    public List<Application> getApplications() {
        return localSettingService.getApplications();
    }

    @RequestMapping(value = "deleteApplication", method = RequestMethod.DELETE)
    public void deleteApplication(@RequestParam(value = "applicationName") String applicationName) {
        localSettingService.deleteApplication(applicationName);
    }

    @RequestMapping(value = "updateApplication", method = RequestMethod.POST)
    public void updateApplication(@RequestParam(value = "applicationName") String applicationName, @RequestParam(value = "description") String description) {
        localSettingService.updateApplication(applicationName, description);
    }

    @RequestMapping(value = "fetchApplication", method = RequestMethod.GET)

    public Application getApplication(@RequestParam(value = "applicationName") String applicationName) {
        return localSettingService.getApplication(applicationName);
    }
}

package com.housescent.commonsettings.service.remote;

import com.housescent.commonsettings.persistence.entities.Application;

import java.util.Map;

/**
 * Created by Siya Sosibo on 21/02/2017.
 */
public interface SettingService {

    String getPropertyValue(String applicationName, String key);

    Map<String, String> getPropertiesForApplicationAsMap(String applicationName);

    Application getApplication(String applicationName);
}

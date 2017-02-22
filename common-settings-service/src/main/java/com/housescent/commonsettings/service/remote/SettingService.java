package com.housescent.commonsettings.service.remote;

import java.util.Map;

/**
 * Created by Siya Sosibo on 21/02/2017.
 */
public interface SettingService {

    String getPropertyValue(String applicationName, String key);

    Map<String, String> getPropertiesForApplicationAsMap(String applicationName);
}

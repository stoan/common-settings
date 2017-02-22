package com.housescent.commonsettings.web.controller;

import com.housescent.commonsettings.service.remote.SettingService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Siya Sosibo on 22/02/2017.
 */
@RestController
@RequestMapping("/settings/")
public class ClientController {

    private SettingService settingService;

    public ClientController(SettingService settingService) {
        this.settingService = settingService;
    }

    @RequestMapping(value = "fetchValue", method = RequestMethod.GET)
    public
    @ResponseBody
    String getProperty(@RequestParam(value = "applicationName") String applicationName, @RequestParam(value = "key") String key) {
        String value = settingService.getPropertyValue(applicationName, key);
        return value;
    }

    @RequestMapping(value = "fetchProperties", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, String> getSettings(@RequestParam(value = "applicationName") String applicationName) {
        Map<String, String> propertiesForApplicationAsMap = settingService.getPropertiesForApplicationAsMap(applicationName);
        return propertiesForApplicationAsMap;
    }
}

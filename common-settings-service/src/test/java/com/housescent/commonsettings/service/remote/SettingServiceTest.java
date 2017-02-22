package com.housescent.commonsettings.service.remote;

import com.housescent.commonsettings.service.ServiceApplicationConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Map;

/**
 * Created by s983620 on 22/02/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplicationConfig.class)
@WebAppConfiguration
public class SettingServiceTest {


    @Autowired
    private SettingService settingService;

    @Test
    public void getPropertyValue() throws Exception {
        String value = settingService.getPropertyValue("TestAppName", "key3");

        Assert.assertEquals("value3", value);
    }

    @Test
    public void getPropertiesForApplicationAsMap() throws Exception {
        Map<String, String> applicationSettingsAsMap = settingService.getPropertiesForApplicationAsMap("TestAppName");

        Assert.assertTrue(applicationSettingsAsMap.containsKey("key1"));
    }

}
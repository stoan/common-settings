package com.housescent.commonsettings.service.local;

import com.housescent.commonsettings.persistence.entities.Application;
import com.housescent.commonsettings.service.ServiceApplicationConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by Siya Sosibo on 21/02/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplicationConfig.class)
@WebAppConfiguration
public class LocalSettingServiceTest {

    @Autowired
    private LocalSettingService localSettingService;

    @Test
    public void getPropertiesForApplication() throws Exception {

    }

    @Test
    public void addProperty() throws Exception {
        boolean saved = localSettingService.addProperty("TestApp", "Key", "value");
        Assert.assertTrue(saved);
    }

    @Test
    public void updateProperty() throws Exception {
        localSettingService.updateProperty("TestAppName", "key2", "value22");

        String newValue = localSettingService.getPropertyValue("TestAppName", "key2");

        Assert.assertEquals("value22", newValue);
    }

    @Test
    public void deleteProperty() throws Exception {
        localSettingService.deleteProperty("TestAppName", "key2");

        String newValue = localSettingService.getPropertyValue("TestAppName", "key2");

        Assert.assertTrue(newValue == null);
    }

    @Test
    public void addApplication() throws Exception {
        boolean saved = localSettingService.addApplication("SpringApp", "Some awesome app description");

        Assert.assertTrue(saved);
    }

    @Test
    public void getApplications() throws Exception {
        List<Application> applications = localSettingService.getApplications();

        Assert.assertTrue(applications.size() == 2);
    }

    @Test
    public void deleteApplication() throws Exception {
        localSettingService.deleteApplication("TestAppName22");

        Application application = localSettingService.getApplication("TestAppName22");

        Assert.assertNull(application);
    }

    @Test
    public void updateApplication() throws Exception {
        localSettingService.updateApplication("TestAppName22", "description22");

        Application application = localSettingService.getApplication("TestAppName22");

        Assert.assertEquals("description22", application.getDescription());
    }

}
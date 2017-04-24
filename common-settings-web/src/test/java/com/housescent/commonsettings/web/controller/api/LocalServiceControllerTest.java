package com.housescent.commonsettings.web.controller.api;

import com.housescent.commonsettings.persistence.entities.Application;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

/**
 * Created by s983620 on 21/04/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LocalServiceControllerTest {

    @LocalServerPort
    int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        RestAssured.basePath = "/admin/";
    }

    @Test
    public void getPropertiesForApplication() throws Exception {
    }

    @Test
    public void addProperty() throws Exception {
    }

    @Test
    public void updateProperty() throws Exception {
    }

    @Test
    public void deleteProperty() throws Exception {
    }

    @Test
    public void addApplication() throws Exception {
    }

    @Test
    public void getApplications() throws Exception {
        given().log().ifValidationFails().port(port).when().get("fetchApplications").then().log().ifValidationFails().statusCode(200);
    }

    @Test
    public void deleteApplication() throws Exception {
    }

    @Test
    public void updateApplication() throws Exception {
    }

    @Test
    public void getApplication() throws Exception {
        Application forObject = this.restTemplate.getForObject("/admin/fetchApplication?applicationName=TestAppName", Application.class);
        System.out.println(forObject);
    }

}
package com.housescent.commonsettings.web.controller.api;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Siya Sosibo on 2017/03/01.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientControllerTest {

    @LocalServerPort
    private int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.basePath = "/settings/";
    }

    @Test
    public void getProperty() throws Exception {
        given().log().ifValidationFails().port(port).get("fetchValue?applicationName=TestAppName&key=key1").then()
                .log().ifValidationFails().statusCode(200).assertThat().body(equalTo("value1"));
    }

    @Test
    public void getSettings() throws Exception {
        given().log().ifValidationFails().port(port).get("fetchProperties?applicationName=TestAppName").then().log()
                .ifValidationFails().statusCode(200).body("key2", equalTo("value2"));

    }

}
package com.housescent.commonsettings.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Siya Sosibo on 08-Nov-15.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.housescent.commonsettings"})
public class WebApplicationConfig {

    public static void main(String[] args) {
        SpringApplication.run(WebApplicationConfig.class, args);
    }
}

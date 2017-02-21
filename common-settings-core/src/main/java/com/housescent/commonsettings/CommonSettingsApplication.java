package com.housescent.commonsettings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Siya Sosibo on 21/02/2017.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.housescent.commonsettings.web"})
public class CommonSettingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonSettingsApplication.class, args);
    }
}

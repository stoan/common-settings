package com.housescent.commonsettings.web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Siya Sosibo on 08-Nov-15.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.housescent.commonsettings.service."})
public class WebApplicationConfig {

}

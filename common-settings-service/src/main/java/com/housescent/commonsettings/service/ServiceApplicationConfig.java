package com.housescent.commonsettings.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Siya Sosibo on 08-Nov-15.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.housescent.commonsettings.service"})
@EntityScan(basePackages = {"com.housescent.commonsettings.persistence"})
@EnableJpaRepositories(basePackages = {"com.housescent.commonsettings.persistence.repositories"})
@EnableTransactionManagement
public class ServiceApplicationConfig {

}

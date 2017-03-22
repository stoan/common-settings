package com.housescent.commonsettings.persistence.repositories;


import com.housescent.commonsettings.persistence.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by S983620 Siya Sosibo on 13/02/2017.
 */
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Application findByApplicationNameIgnoreCase(String applicationName);
}

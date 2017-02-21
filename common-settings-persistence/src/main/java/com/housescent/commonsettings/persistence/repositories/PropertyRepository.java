package com.housescent.commonsettings.persistence.repositories;


import com.housescent.commonsettings.persistence.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by S983620 - Siya Sosibo on 13/02/2017.
 */
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    Property findByApplication_applicationNameAndKey(String applicationName, String key);

    List<Property> findByApplication_applicationName(String applicationName);
}

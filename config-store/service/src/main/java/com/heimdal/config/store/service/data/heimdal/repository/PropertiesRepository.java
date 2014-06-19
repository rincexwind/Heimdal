/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service.data.heimdal.repository;

import com.heimdal.config.store.service.data.heimdal.entity.*;
import org.springframework.data.repository.*;

/**
 * 
 * @author Grant Gortsema
 *
 */
public interface PropertiesRepository extends CrudRepository<PropertiesEntity, Long>{

	PropertiesEntity findOneByKey(String key);	
}

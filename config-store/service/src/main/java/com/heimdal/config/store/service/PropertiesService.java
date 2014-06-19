/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service;

import com.heimdal.config.store.service.data.heimdal.entity.PropertiesEntity;
import com.heimdal.config.store.service.model.Property;

/**
 * 
 * @author Grant Gortsema
 *
 */
public interface PropertiesService {

	public Property lookup(String key);
	public Property create(Property property);
	public void update(Property property);
	PropertiesEntity save(PropertiesEntity property);
}
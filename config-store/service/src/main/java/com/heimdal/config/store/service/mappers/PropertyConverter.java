/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service.mappers;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.heimdal.config.store.service.Creator;
import com.heimdal.config.store.service.Merger;
import com.heimdal.config.store.service.data.heimdal.entity.PropertiesEntity;
import com.heimdal.config.store.service.model.Property;


/**
 * This is the Converter that will handle converting between Property and PropertyEntity
 * Updates are considered a complete snapshot so that leaving out a field
 * will null it out.
 * 
 * @author Grant Gortsema
 *
 */
@Component
public class PropertyConverter implements Converter<PropertiesEntity, Property>, Merger<PropertiesEntity, Property>, Creator<PropertiesEntity, Property>{
	
	@Override
	public Property convert(PropertiesEntity entity) {

		Property property = new Property();
		property.setKey(entity.getKey());
		property.setValue(entity.getValue());
		return property;
	}
	
	@Override
	public void merge(Property input, PropertiesEntity target) {
		
		
	}

	@Override
	public PropertiesEntity create(Property input) {
		
		
		return null;
	}

}

/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heimdal.config.store.service.PropertiesService;
import com.heimdal.config.store.service.data.heimdal.entity.PropertiesEntity;
import com.heimdal.config.store.service.data.heimdal.repository.PropertiesRepository;
import com.heimdal.config.store.service.mappers.PropertyConverter;
import com.heimdal.config.store.service.model.Property;

/**
 * 
 * @author Grant Gortsema
 *
 */
@Service
@Transactional
public class PropertiesServiceImpl implements PropertiesService {
	
	@Autowired(required=true)
	private PropertiesRepository propertyRepo;
	
	@Autowired(required=true)
	private PropertyConverter converter;

	@Override
	public Property lookup(String key) {
		return converter.convert(propertyRepo.findOneByKey(key));
	}

	@Override
	public Property create(Property property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Property property) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PropertiesEntity save(PropertiesEntity property) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

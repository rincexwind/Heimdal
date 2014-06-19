/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service.authorization.impl;

import org.springframework.stereotype.Component;
import com.heimdal.config.store.service.authorization.AuthorizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is the abstraction for authorizing Heimdal services. This will
 * be for simple header authention probably to be either tied into Spring
 * Security or replaced by Spring Security at a later date
 * 
 * @author Grant Gortsema
 *
 */
@Component
public class AuthorizationServiceImpl implements AuthorizationService {
	
	final static Logger log = LoggerFactory.getLogger(AuthorizationServiceImpl.class);
	
	//$GG TODO get from properties
	public String ATG_KEY = "123";
	
	//$GG TODO get from properties
	public String USE_AUTH = "false";
	

	@Override
	public boolean lookupAuth(String methodName, String credentials) {	
				
		if(!USE_AUTH.equalsIgnoreCase("true")) {
			return true;
		}
		
		if(credentials == null) {
			return false;
		}
		
		credentials = credentials.trim();
		//the token comes from the header, split away the "Authorization" part
		String credentialsArray[] = credentials.split(" ");
		
		if(credentialsArray == null || credentialsArray.length != 2) {
			return false;
		}
				
		if(!credentialsArray[1].equalsIgnoreCase(ATG_KEY)) {
			return false;
		}
		
		return true;
	}

}

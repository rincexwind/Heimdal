/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service.authorization;

/**
 * 
 * @author Grant Gortsema
 *
 */
public interface AuthorizationService {
	
	public boolean lookupAuth(String methodName,String credentials);

}

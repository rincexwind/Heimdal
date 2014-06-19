/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service.errors;

/**
 * 
 * @author Grant Gortsema
 *
 */
public enum PropertiesErrors {
	
	DATA_INTEGRITY_VIOLATION("1000"),
	ENTITY_NOT_FOUND("2000"),
	ILLEGAL_STATE_EXCEPTION("3000"),
	NO_CHANGE("4000");
	
	private final String CODE;
	
	PropertiesErrors(String CODE) {
		this.CODE = CODE;
	}
	
	public String code() {
		return CODE;
	}
}

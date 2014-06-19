/**
 * NEST Services Project (nest)
 * Copyright (c) 2014 Nook Media LLC., All Rights Reserved.
 */
package com.heimdal.config.store.service.base.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * This Class is the required base controller for all of the nest Jersey controllers. This class is used so that aop
 * advice on controller methods can have access to headers and other important information as well as maintaining
 * consistency in how we get context information, and lastly to provide a home for any of our house cleaning jobs such
 * as logging or profiling if needed. There is also a validation method that is available to all the jersey controllers 
 * to validate using JSR-303 as long as they have a provider wired in.
 * 
 * @author Grant Gortsema
 */
public class HeimdalBaseController {
	
	@Context
	private HttpHeaders headers;
	
	@Autowired 
	private Validator validator;

	public HttpHeaders getHeaders() {
		return headers;
	}

	public void validate(Object o) {
		StringBuilder builder = new StringBuilder();
		Set<ConstraintViolation<Object>> errors = validator.validate(o);
		boolean hasErrors = false;
		for (ConstraintViolation<Object> error : errors) {
			builder.append(error.getMessage()).append(" | ");
			hasErrors = true;
		}
		if(hasErrors) {
			String returnString = builder.toString();
			throw new DataIntegrityViolationException(returnString.substring(0, returnString.length()-2));
		}
	}
}

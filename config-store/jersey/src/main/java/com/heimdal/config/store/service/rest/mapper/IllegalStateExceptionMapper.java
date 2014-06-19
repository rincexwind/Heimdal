/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service.rest.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.heimdal.config.store.service.errors.PropertiesErrors;
import com.heimdal.config.store.service.errors.ErrorResponse;

/**
 * 
 * @author Grant Gortsema
 *
 */
@Component
@Provider
public class IllegalStateExceptionMapper implements ExceptionMapper<IllegalStateException> {

	@Override
	public Response toResponse(IllegalStateException exception) {		
		ErrorResponse response = new ErrorResponse();
		response.addError(PropertiesErrors.ILLEGAL_STATE_EXCEPTION,exception.getMessage());
		return Response.status(Response.Status.CONFLICT).entity(response).build();
	}

}

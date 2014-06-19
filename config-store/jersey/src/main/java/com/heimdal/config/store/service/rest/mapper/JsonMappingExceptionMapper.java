/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service.rest.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.JsonMappingException;
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
public class JsonMappingExceptionMapper implements ExceptionMapper<JsonMappingException> {

	@Override
	public Response toResponse(JsonMappingException exception) {		
		ErrorResponse response = new ErrorResponse();
		response.addError(PropertiesErrors.DATA_INTEGRITY_VIOLATION,exception.getMessage());
		return Response.status(Response.Status.BAD_REQUEST).entity(response).build();
	}

}

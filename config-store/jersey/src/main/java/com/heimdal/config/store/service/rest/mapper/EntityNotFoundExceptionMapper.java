/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service.rest.mapper;

import javax.persistence.EntityNotFoundException;
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
public class EntityNotFoundExceptionMapper implements ExceptionMapper<EntityNotFoundException> {

	@Override
	public Response toResponse(EntityNotFoundException exception) {
		ErrorResponse response = new ErrorResponse();
		response.addError(PropertiesErrors.ENTITY_NOT_FOUND,exception.getMessage());
		return Response.status(Response.Status.NOT_FOUND).entity(response).build();
	}
}

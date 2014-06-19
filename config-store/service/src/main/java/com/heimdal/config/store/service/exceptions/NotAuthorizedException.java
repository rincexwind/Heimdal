/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * While Jersy 2.0 has a NotAuthorizedException until we upgrade we need one of
 * our own so we just extend the javax.ws.rs.WebApplicationException to return
 * the correct not authorized status code.
 * 
 * @author Grant Gortsema
 */
public class NotAuthorizedException extends WebApplicationException {
	
	private static final long serialVersionUID = 1L;
	
	public NotAuthorizedException(String message) {
        super(Response.status(Response.Status.UNAUTHORIZED)
            .entity(message).type(MediaType.TEXT_PLAIN).build());
    }

}

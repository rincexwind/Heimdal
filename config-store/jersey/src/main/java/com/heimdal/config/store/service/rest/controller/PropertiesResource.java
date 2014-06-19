/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.heimdal.config.store.service.PropertiesService;
import com.heimdal.config.store.service.aop.annotations.AuthorizationRequired;
import com.heimdal.config.store.service.base.controller.HeimdalBaseController;
import com.heimdal.config.store.service.model.Property;
import com.sun.jersey.api.NotFoundException;

/**
 * This is the resource for properties.
 * We derive from the HeimdalBaseController which allows us to use the @AuthorizationRrequired annotation as
 * well as for providing a specialized hook for the @Valid annotation that will format the errors we return
 * to the caller.
 * 
 * @author Grant Gortsema
 *
 */
@Controller
@Path("/properties")
public class PropertiesResource extends HeimdalBaseController {

	@Autowired
	private PropertiesService service;
		
	@GET
	@Path("{key}")
	@Produces(MediaType.APPLICATION_JSON)
	@AuthorizationRequired
	public Property lookupCustomer(@PathParam("key") String key) throws NotFoundException {
		
		return service.lookup(key);
	}
}

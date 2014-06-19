/**
 * NEST Services Project (nest)
 * Copyright (c) 2014 Nook Media LLC., All Rights Reserved.
 */
package com.heimdal.config.store.service.rest.controller;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

import com.heimdal.common.logging.annotation.Log;
import com.heimdal.config.store.service.base.controller.HeimdalBaseController;

import org.slf4j.Logger;

/**
 * This is the start of what will be the controller for all the health check and dashboard services.
 * For now it just gives the project version.
 * 
 * @author Grant Gortsema
 *
 */
@Controller
@Path("/dashboard")
public class DashboardController extends HeimdalBaseController {
	
	@Resource 
	String projectVersion;
	
	 @Log Logger logger;

	
	@GET
	@Path("version")
	public Response getProjectVersion() {
		
		logger.debug("d-getting dashboard version: " + projectVersion);
		logger.error("e-getting dashboard version: " + projectVersion);		
		String version = "";
		if (projectVersion == null) version += "projectVersion is null";
		else version = projectVersion;
		
		return Response.ok(version).build();
	}
	
}

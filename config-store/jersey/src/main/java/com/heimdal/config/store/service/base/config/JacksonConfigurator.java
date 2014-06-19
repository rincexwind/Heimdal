package com.heimdal.config.store.service.base.config;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.ws.rs.ext.Provider;
import javax.ws.rs.Produces; 


@Component
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonConfigurator implements ContextResolver<ObjectMapper> {

	private final ObjectMapper jacksonObjectMapper;

    public JacksonConfigurator() throws Exception {
    	jacksonObjectMapper = new JaxbJacksonObjectMapper();
    }

    @Override
    public ObjectMapper getContext(final Class<?> objectType) {
        return jacksonObjectMapper;
    }



}
/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service

import spock.lang.*

import org.junit.Test


import com.heimdal.config.store.service.impl.PropertiesServiceImpl
import groovy.xml.*

/**
 * 
 * @author Grant Gortsema
 *
 */
class ConfigStoreServiceSpecificationTest extends Specification {
	
	@Shared 
	PropertiesService propertiesService
	

	
	@Test
	def "dummy test to see if this works"() {
		
		setup :
		propertiesService = new PropertiesServiceImpl()
	
		when : "we do nothing"
		def x = "Grant1"

			
		then : "we should get back Grant1"
		x == "Grant1"
	}
}
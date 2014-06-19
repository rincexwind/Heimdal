/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service.data.heimdal.entity

import javax.xml.bind.annotation.*
import javax.persistence.*

import javax.validation.constraints.*


/**
 * 
 * @author Grant Gortsema
 *
 */
@XmlRootElement
@XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
@Entity
@Table(name="properties")
public class PropertiesEntity {
	

	
	@Id @GeneratedValue
	long id
	
	@NotNull
	String key
	
	String value
	
	String environment
	
	String application
	
	Date created
	
	Date modified
	
}

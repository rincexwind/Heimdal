/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service.errors

import javax.xml.bind.annotation.*
import org.codehaus.jackson.map.annotate.JsonSerialize

/**
 * 
 * @author Grant Gortsema
 *
 */
@XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
@XmlRootElement(name='response')
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
class ErrorElement {
	
	String code;
	String description;

}

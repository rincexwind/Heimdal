/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service.model

import javax.validation.constraints.*;
import javax.xml.bind.annotation.*;

import org.codehaus.jackson.annotate.*;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 
 * @author Grant Gortsema
 *
 */
@XmlRootElement
@XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
class Property {
	
	@NotNull(message="key can not be null")
	@Size(min=1, message="key can not be blank")
	String key
	String value

}

/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service.rest.response

import javax.xml.bind.annotation.*


/**
 * 
 * @author Grant Gortsema
 *
 */
@XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
@XmlRootElement(name='response')
public class CreationResponse {

	String mercuryId
	String entity
}

/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service.errors

import javax.xml.bind.annotation.*
import org.codehaus.jackson.map.annotate.JsonSerialize
import org.codehaus.jackson.annotate.JsonIgnore
import com.heimdal.config.store.service.errors.ErrorElement

/**
 * 
 * @author Grant Gortsema
 *
 */
@XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
@XmlRootElement(name='response')
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ErrorResponse {
	
	@XmlElement(name="errors")
	List<ErrorElement> errors = new ArrayList<ErrorElement>()	
	@XmlTransient
	@JsonIgnore
	boolean hasError = false

	public void addError(String code, String description) {
		hasError = true
		ErrorElement e = new ErrorElement()
		e.setCode(code)
		e.setDescription(description)
		errors.add(e)
	}

	public void addError(ErrorElement newError) {
		hasError = true
		ErrorElement e = new ErrorElement()
		e.setCode(newError.code())
		e.setDescription(newError.description())
		errors.add(e)
	}

	public void addError(ErrorElement newError,String additionalMessage) {
		hasError = true
		ErrorElement e = new ErrorElement()
		e.setCode(newError.code())
		e.setDescription(newError.description() + additionalMessage)
		errors.add(e)
	}
	
	public void addError(PropertiesErrors accountError, String description) {
		hasError = true
		ErrorElement e = new ErrorElement()
		e.setCode(accountError.CODE)
		e.setDescription(description)
		errors.add(e)
	}
	
	
}


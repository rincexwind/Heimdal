/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service.aop.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is a marker interface for AOP before advice to be applied to
 * the pointcut that says any method that has this annotation AND that method is
 * on a class that extends HeimdalBaseController
 * 
 * The advice related to this annotation will check for the authorized header on 
 * the request and do a lookup to see if the requester is allowed to use this method.
 * 
 * @author Grant Gortsema
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AuthorizationRequired {

}

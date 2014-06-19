/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.common.core.context;

/**
 * 
 * @author Grant Gortsema
 *
 */
public class AbstractContext {

	public AbstractContext() {
		ContextManager.getInstance().setContext(this);
	}
	
	public static <T> T get(Class<T> clazz, T nullContext) {
		T context = ContextManager.getInstance().getContext(clazz);
		if (context == null) return nullContext;
		return context;
	}
}

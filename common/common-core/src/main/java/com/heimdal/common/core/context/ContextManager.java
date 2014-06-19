/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.common.core.context;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Grant Gortsema
 *
 */
public class ContextManager {
	
	private static final ThreadLocal<ContextManager> threadLocal = new ThreadLocal<ContextManager>() {
		@Override
		protected ContextManager initialValue() {
			return new ContextManager();
		}
	};

	private final Map<Class<?>, Object> contexts = new HashMap<Class<?>, Object>();
	
	private ContextManager() {
		// Hide constructor
	}
	
	static ContextManager getInstance() {
		return threadLocal.get();
	}
	
	static void clearInstance() {
		threadLocal.remove();
	}
	
	@SuppressWarnings("unchecked")
	<T> T getContext(Class<T> clazz) {
		return (T) contexts.get(clazz);
	}
	
	void setContext(Object object) {
		contexts.put(object.getClass(), object);
	}
}

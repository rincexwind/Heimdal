/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service;

/**
 * 
 * @author Grant Gortsema
 *
 * @param <T>
 * @param <I>
 */
public interface Merger<T, I> {

	void merge(I input, T target);
}

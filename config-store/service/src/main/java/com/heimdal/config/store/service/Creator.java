/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.config.store.service;

/**
 * 
 * @author Grant Gortsema
 *
 * @param <M>
 * @param <I>
 */
public interface Creator<M, I> {

	M create(I input);
}

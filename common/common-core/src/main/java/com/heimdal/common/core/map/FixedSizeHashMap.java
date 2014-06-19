/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.common.core.map;

import java.util.LinkedHashMap;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Grant Gortsema
 *
 * @param <K>
 * @param <V>
 */
public class FixedSizeHashMap<K, V> extends LinkedHashMap<K, V> {
	
	private static final Logger log = LoggerFactory.getLogger(FixedSizeHashMap.class);

	private static final long serialVersionUID = 2496237579566216604L;

	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	private final DropListener<K, V> dropListener;
	private final int maxSize;

	public FixedSizeHashMap(int maxSize, DropListener<K, V> dropListener) {
		super((int) (maxSize / DEFAULT_LOAD_FACTOR), DEFAULT_LOAD_FACTOR);
		this.maxSize = maxSize;
		this.dropListener = dropListener;
	}
	
	protected DropListener<K, V> getDropListener() {
		return this.dropListener;
	}
	
	private int getMaxSize() {
		return this.maxSize;
	}
	
	@Override
	public void clear() {
		Set<K> keys = keySet();
		for (K key : keys) {
			remove(key);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public V remove(Object key) {
		V value = super.remove(key);
		
		if (value != null) notifyDropListener((K) key, value);
		
		return value;
	}
	
	protected void notifyDropListener(K key, V value) {
		try {				
			getDropListener().entryDropped(key, value);
		} catch (Exception e) {
			log.error("Exception in drop listener", e);
		}
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		if (size() >= getMaxSize()) {
			notifyDropListener(eldest.getKey(), eldest.getValue());
			return true;
		}
		return false;
	}

	public static interface DropListener<K, V> {
		
		void entryDropped(K key, V value);
		
	}
}
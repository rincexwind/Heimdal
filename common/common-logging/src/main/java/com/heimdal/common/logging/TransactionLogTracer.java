/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.common.logging;

import java.util.Map;
import ch.qos.logback.classic.spi.LoggingEvent;
import com.heimdal.common.core.map.FixedSizeHashMap;

/**
 * 
 * @author Grant Gortsema
 *
 */
public class TransactionLogTracer {

	private static final int MAX_TRANSACTIONS = 25;

	private final static TransactionLogTracer instance = new TransactionLogTracer();

	private final Map<String, TransactionLogMonitor> transactionLogMonitors;

	private TransactionLogTracer() {
		this.transactionLogMonitors = new FixedSizeHashMap<String, TransactionLogTracer.TransactionLogMonitor>(
				MAX_TRANSACTIONS, new FixedSizeHashMap.DropListener<String, TransactionLogMonitor>() {
					@Override
					public void entryDropped(String transactionId, TransactionLogMonitor monitor) {
						monitor.unregistered(transactionId);
					}
				});
	}
	
	private Map<String, TransactionLogMonitor> getTransactionLogMonitors() {
		return this.transactionLogMonitors;
	}
	
	public void registerMonitor(String transactionId, TransactionLogMonitor monitor) {
		getTransactionLogMonitors().put(transactionId, monitor);
	}
	
	public void unregisterMonitor(String transactionId) {
		getTransactionLogMonitors().remove(transactionId);
	}

	public static TransactionLogTracer getInstance() {
		return instance;
	}

	public void trace(String transactionId, LoggingEvent loggingEvent) {
		TransactionLogMonitor monitor = getTransactionLogMonitors().get(transactionId);
		if (monitor == null) return;
		
		monitor.loggingEvent(transactionId, loggingEvent);
	}

	public static interface TransactionLogMonitor {
		
		void unregistered(String transactionId);
		
		void loggingEvent(String transactionId, LoggingEvent loggingEvent);

	}

}

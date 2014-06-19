/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.common.logging.filter;

import org.slf4j.Marker;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;
import com.heimdal.common.logging.TransactionLogTracer;
import com.heimdal.common.logging.context.LoggingRequestContext;

/**
 * 
 * @author Grant Gortsema
 *
 */
public class TransactionTurboFilter extends TurboFilter {
	
	private final TransactionLogTracer transactionLogTracer;

	public TransactionTurboFilter() {
		this.transactionLogTracer = TransactionLogTracer.getInstance();
	}

	protected TransactionLogTracer getTransactionLogTracer() {
		return this.transactionLogTracer;
	}

	@Override
	public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {
		LoggingRequestContext context = LoggingRequestContext.getCurrent();
		if (context == null) return FilterReply.NEUTRAL;

		if (context.getMonitor() != null) {
			LoggingEvent le = new LoggingEvent(Logger.FQCN, logger, level, format, t, params);
			le.setMarker(marker);
			getTransactionLogTracer().trace(context.getMonitor(), le);
		}

		if (context.getLevel() == null) return FilterReply.NEUTRAL;

		if (level.isGreaterOrEqual(context.getLevel())) {
			return FilterReply.ACCEPT;
		}

		return FilterReply.NEUTRAL;
	}
}

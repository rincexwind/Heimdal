/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.common.logging.context;

import com.heimdal.common.core.context.AbstractContext;
import ch.qos.logback.classic.Level;

/**
 * 
 * @author Grant Gortsema
 *
 */
public final class LoggingRequestContext extends AbstractContext {

	private static final LoggingRequestContext NULL_CONTEXT = new LoggingRequestContext(new Builder());
	
	private final Level level;
	private final String monitor;

	private LoggingRequestContext(Builder builder) {
		this.level = builder.level == null ? null : Level.toLevel(builder.level);
		this.monitor = builder.monitor;
	}

	public Level getLevel() {
		return level;
	}

	public String getMonitor() {
		return monitor;
	}

	public static LoggingRequestContext getCurrent() {
		return get(LoggingRequestContext.class, NULL_CONTEXT);
	}
	
	static class Builder {
		String level;
		String monitor;
		
		public Builder setLevel(String level) {
			this.level = level;
			return this;
		}
		
		public Builder setMonitor(String monitor) {
			this.monitor = monitor;
			return this;
		}
		
		public LoggingRequestContext build() {
			return new LoggingRequestContext(this);
		}
	}
}

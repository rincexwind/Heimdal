/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
package com.heimdal.common.logging.util;

import org.xml.sax.helpers.AttributesImpl;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.action.JMXConfiguratorAction;
import ch.qos.logback.core.joran.spi.ActionException;

/**
 * 
 * @author Grant Gortsema
 *
 */
public class LogJmxUtil {

	public static void jmxConfigurator(LoggerContext context) {
		JMXConfiguratorAction jmxConfiguratorAction = new JMXConfiguratorAction();
		jmxConfiguratorAction.setContext(context);
		try {
			jmxConfiguratorAction.begin(null, null, new AttributesImpl());
		} catch (ActionException e) {
			throw new IllegalStateException(e);
		}
	}
}

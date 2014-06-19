/**
 * Heimdal Project
 * Copyright (c) 2014 Grant Gortsema, All Rights Reserved.
 */
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.filter.ThresholdFilter
import ch.qos.logback.classic.boolex.GEventEvaluator
import ch.qos.logback.classic.net.SyslogAppender
import ch.qos.logback.core.filter.EvaluatorFilter
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy
import com.heimdal.common.logging.filter.TransactionTurboFilter
import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.INFO
import static ch.qos.logback.classic.Level.TRACE
import static ch.qos.logback.classic.Level.ERROR
import static ch.qos.logback.classic.Level.WARN
import static ch.qos.logback.classic.Level.ALL
import static ch.qos.logback.core.spi.FilterReply.DENY
import static ch.qos.logback.core.spi.FilterReply.NEUTRAL

turboFilter(TransactionTurboFilter)

def generalLogPattern = "%date|%thread|%level|%message%n"
appender("stdout", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
	pattern = generalLogPattern
  }
}

appender("configStoreService", RollingFileAppender) {
	file = "logs/configStoreService.log"
	encoder(PatternLayoutEncoder) {
	  pattern = generalLogPattern
	}
	rollingPolicy(TimeBasedRollingPolicy) {
	  fileNamePattern = "logs/configStoreService.%d{yyyy-MM-dd-HH}.log"
	}
  }

root(ERROR, ["stdout"])


logger("com.heimdal.config.store", DEBUG , ["configStoreService", "stdout"], false)

// External
logger("org.apache", INFO, ["stdout"], false)
logger("org.springframework", INFO, ["stdout"], false)
logger("org.springframework.jms.listener.DefaultMessageListenerContainer", ERROR, ["stdout"], false)

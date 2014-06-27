package com.honestspring.rose4j.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

public class LogUtils {
	 Logger log = LoggerFactory.getLogger("Rose4j");
	public LogUtils(){
		 LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
	        JoranConfigurator configurator = new JoranConfigurator();
	        configurator.setContext(lc);
	        lc.reset();
	        try {
	            configurator.doConfigure("logback.xml");
	       } catch (JoranException e) {
	            e.printStackTrace();
	        }
	}
	public  void debug(String info){
		log.debug(info);
	}
	public  void info(String info){
		log.info(info);
	}
	public void error(String info,Exception e){
		log.error(info, e);
	}
}

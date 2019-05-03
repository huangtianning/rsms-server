package com.whut.www.log;

import org.apache.log4j.Logger;

public class LoggerTest {
	private static Logger log = Logger.getLogger(LoggerTest.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log.debug("This is debug");
		log.info("This is info");
		log.warn("This is warn");
		log.error("This is error");
		log.fatal("This is fatal");
		log.fatal("This is a fatal");
	}

}

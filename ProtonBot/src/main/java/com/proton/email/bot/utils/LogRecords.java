package com.proton.email.bot.utils;

import java.util.logging.Logger;

public class LogRecords {
	
	private static final String LOG_PATH = System.getProperty("user.dir") + "/src/tests/logs";
	private static final Logger LOGGER = Logger.getLogger(LogRecords.class.getName());
	
	public static void info(String s) {
		LOGGER.info(s);
	} 
	
	public static void warning(String s) {
		LOGGER.warning(s);
	}
	
	
}

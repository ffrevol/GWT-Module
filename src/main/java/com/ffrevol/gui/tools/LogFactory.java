package com.ffrevol.gui.tools;

import java.util.logging.Logger;

import com.google.gwt.logging.client.SystemLogHandler;

public class LogFactory {	
	static Logger logger = Logger.getLogger("GUILogger");
	static {
		logger.addHandler(new SystemLogHandler());		
	}
	public static Logger getLogger() {		
		return logger;
	}

}

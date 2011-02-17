package com.ffrevol.gui.tools;

import java.util.logging.Logger;

public class LogFactory {	
	static Logger logger = Logger.getLogger("GUILogger");

	public static Logger getLogger() {		
		return logger;
	}

}

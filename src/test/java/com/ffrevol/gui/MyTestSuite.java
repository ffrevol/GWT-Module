package com.ffrevol.gui;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.ffrevol.gui.client.TestProvisioning_module;
import com.google.gwt.junit.tools.GWTTestSuite;

public class MyTestSuite extends GWTTestSuite {
	public static Test suite() {
	    TestSuite suite = new TestSuite("Test for a GWT Application");
	    suite.addTestSuite(TestProvisioning_module.class);
	    return suite;
	  }

}

package com.ffrevol.gui;

import junit.framework.Test;
import junit.framework.TestCase;

import com.ffrevol.gui.client.Provisioning_moduleTestGwt;
import com.google.gwt.junit.tools.GWTTestSuite;


public class GwtTestSuite extends TestCase  {
	public static Test suite()
    {
        GWTTestSuite suite = new GWTTestSuite( "All Gwt Tests" );
        suite.addTestSuite( Provisioning_moduleTestGwt.class );
        return suite;
    }
	
}

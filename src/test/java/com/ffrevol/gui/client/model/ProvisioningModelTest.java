package com.ffrevol.gui.client.model;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.gwt.xml.client.Element;

public class ProvisioningModelTest {

	@Before
	public void setUp() throws Exception {
		ProvisioningI model = new ProvisioningModel();
		/*Element _segmentElement;
		model.AddSegment(new Segment(_segmentElement));*/
	}
	
	@Test
	public void okTest() throws Exception {
		assertTrue(true);
	}
	@Ignore
	@Test
	public void GetSegment()
	{	
		String expected = "http";
		/*SegmentI segment = provisioning.Segment(expected);
		assertThat(segment.Name(), equalTo(expected));*/
	}
	

}

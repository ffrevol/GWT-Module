package com.ffrevol.gui.client.model;

import java.util.List;

import com.google.gwt.xml.client.Document;

public interface ProvisioningI extends ElementI {
	List<SegmentI> Segment();	
	void AddSegment(SegmentI segment);
	SegmentI RemoveSegment(SegmentI segment);
	void setElement(Document messageDom);	
	String XMLStringValue();
	SegmentI getSegment(String name);
}

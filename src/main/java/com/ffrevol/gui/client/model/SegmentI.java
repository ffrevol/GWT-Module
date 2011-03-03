package com.ffrevol.gui.client.model;

import java.util.List;

public interface SegmentI  extends ElementI{
	static final String NAME_TAG = "type";
	static final String SEGMENT_TAG = "SEGMENT";
	List<ServiceI> Service();
	ServiceI NewService(String name, String id);
	void AddService(ServiceI service);	
	ServiceI RemoveService(ServiceI service);
	String Name();	
}

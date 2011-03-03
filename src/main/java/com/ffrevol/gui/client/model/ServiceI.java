package com.ffrevol.gui.client.model;

import java.util.List;

public interface ServiceI  extends ElementI {
	static final String ID_TAG = "id";
	static final String NAME_TAG = "name";
	static final String SERVICE_TAG = "SERVICE";
	String Name();
	void Name(String name);
	String Id();
	void Id(String id);
	List<FilterI> Filter();
	FilterI NewFilter(String url);
	void AddFilter(FilterI filter);	
	FilterI RemoveFilter(FilterI filter);
	Object Key();
}

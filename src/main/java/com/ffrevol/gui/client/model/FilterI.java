package com.ffrevol.gui.client.model;

public interface FilterI  extends ElementI {
	static final String FILTER_TAG = "FILTER";
	static final String URL_TAG = "url";
	String URL();
	void URL(String url);	
}

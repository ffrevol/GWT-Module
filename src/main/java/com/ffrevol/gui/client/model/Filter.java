package com.ffrevol.gui.client.model;

import com.ffrevol.gui.tools.LogFactory;
import com.google.gwt.xml.client.Element;

public class Filter implements FilterI {

	private final Element filterElement;
	
	public Element getElement() {
		return filterElement;
	}

	public Filter(Element _filterElement) {
		filterElement = _filterElement;
		LogFactory.getLogger().fine("New Filter : " + filterElement.toString());
	}

	@Override
	public String URL() {
		return filterElement.getAttribute(FilterI.URL_TAG);
	}

	@Override
	public void URL(String url) {
		filterElement.setAttribute(FilterI.URL_TAG, url);
		
	}
	
}

package com.ffrevol.gui.client.model;

import java.util.LinkedList;
import java.util.List;

import com.ffrevol.gui.tools.LogFactory;
import com.google.gwt.xml.client.Element;

public class Service implements ServiceI {

	private final Element serviceElement;
	private List<FilterI> list;
	public Element getElement() {
		return serviceElement;
	}
	public Service(Element _serviceElement) {
		serviceElement = _serviceElement;
		list = new LinkedList<FilterI>();
		LogFactory.getLogger().fine("New Service : " + serviceElement.toString());
	}
	protected void InsertFilter(FilterI filter)
	{
		list.add(filter);
	}
	@Override
	public void AddFilter(FilterI filter) {
		InsertFilter(filter);
		serviceElement.appendChild(filter.getElement());
	}
	@Override
	public FilterI RemoveFilter(FilterI filter) {
		serviceElement.removeChild(filter.getElement());
		return list.remove(filter) ? filter : null;
	}

	@Override
	public List<FilterI> Filter() {
		return list;
	}

	@Override
	public String Id() {
		return serviceElement.getAttribute(ServiceI.ID_TAG);
	}

	@Override
	public void Id(String id) {
		serviceElement.setAttribute(ServiceI.ID_TAG, id);
	}

	@Override
	public String Name() {
		return serviceElement.getAttribute(ServiceI.NAME_TAG);
	}

	@Override
	public void Name(String name) {
		serviceElement.setAttribute(ServiceI.NAME_TAG, name);
	}
	@Override
	public FilterI NewFilter(String url) {
		Element newFilterNode = serviceElement.getOwnerDocument().createElement(FilterI.FILTER_TAG);
		newFilterNode.setAttribute(FilterI.URL_TAG, url);		
		return new Filter(newFilterNode);
	}
	@Override
	public Object Key() {
		return Id() + Name();
	}
	

}

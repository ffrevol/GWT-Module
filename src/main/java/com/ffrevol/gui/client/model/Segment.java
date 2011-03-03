package com.ffrevol.gui.client.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.ffrevol.gui.tools.LogFactory;
import com.google.gwt.xml.client.Element;

public class Segment implements SegmentI {

	public Element getElement() {
		return segmentElement;
	}
	private final Element segmentElement;	
	private HashMap<ServiceI, ServiceI> map;

	public Segment(Element _segmentElement) {
		segmentElement = _segmentElement;
		map = new HashMap<ServiceI, ServiceI>();		
		LogFactory.getLogger().fine("New Segment : " + segmentElement.toString());
	}
	
	protected void InsertService(ServiceI service)
	{
		map.put(service, service);		
	}

	@Override
	public List<ServiceI> Service() {
		return new ArrayList<ServiceI>(map.values());				
	}

	@Override
	public void AddService(ServiceI service) {
		InsertService(service);
		segmentElement.appendChild(service.getElement());
	}

	@Override
	public ServiceI RemoveService(ServiceI service) {
		LogFactory.getLogger().fine("Remove element " + service.toString() + " inside " + segmentElement.toString());
		ServiceI removed = map.remove(service);		
		segmentElement.removeChild(removed.getElement());
		return removed;
	}

	@Override
	public String Name() {
		return segmentElement.getAttribute(SegmentI.NAME_TAG);
	}

	@Override
	public ServiceI NewService(String name, String id) {
		Element newServiceNode = segmentElement.getOwnerDocument().createElement(ServiceI.SERVICE_TAG);
		newServiceNode.setAttribute(ServiceI.NAME_TAG, name);
		newServiceNode.setAttribute(ServiceI.ID_TAG, id);		
		return new Service(newServiceNode);		
	}
	
}

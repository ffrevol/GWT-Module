package com.ffrevol.gui.client.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceTypeImpl implements ServiceType {

	private final String name;
	private final Map<String, Service> service = new HashMap<String, Service>();
	public ServiceTypeImpl(String _name) {
		this.name = _name;
	}

	@Override
	public List<Service> getService() {
		return new ArrayList<Service>(service.values());
	}

	public void addService(Service serviceImpl) {
		service.put(serviceImpl.Name(), serviceImpl);
	}

	@Override
	public String Name() {
		return name;
	}

}

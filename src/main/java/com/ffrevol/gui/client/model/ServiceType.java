package com.ffrevol.gui.client.model;

import java.util.List;

public interface ServiceType {

	String Name();
	List<Service> getService();
	void addService(Service serviceImpl);

}

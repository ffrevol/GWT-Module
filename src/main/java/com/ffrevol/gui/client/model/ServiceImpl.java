package com.ffrevol.gui.client.model;

public class ServiceImpl implements Service {

	private String name;

	public ServiceImpl(String prefix, int i) {
		name = "Service" + prefix + i;
	}

	@Override
	public String Name() {
		return name;
	}

}

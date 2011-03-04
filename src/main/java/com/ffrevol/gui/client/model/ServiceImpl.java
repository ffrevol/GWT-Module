package com.ffrevol.gui.client.model;

public class ServiceImpl implements Service {

	private String name;
	private int id;

	public ServiceImpl(String prefix, int i) {
		name = "Service" + prefix + i;
		id = i;
	}

	@Override
	public String Name() {
		return name;
	}

	@Override
	public int Id() {
		return id;
	}

}

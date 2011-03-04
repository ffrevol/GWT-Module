package com.ffrevol.gui.client.model;

import java.util.HashMap;
import java.util.Map;

public class ProvisioningModelImpl implements ProvisioningModel {

	private int nbServiceMMS = 15;
	private int nbServiceWAP = 10;
	
	private Map<String, ServiceType> type = new HashMap<String, ServiceType>();
	public ProvisioningModelImpl() {
		init();
	}

	private void init() {
		ServiceType mmsType = new ServiceTypeImpl("MMS");
		for (int i = 0; i < nbServiceMMS; i++) {
			mmsType.addService(new ServiceImpl("MMS", i));
		}
		ServiceType wapType = new ServiceTypeImpl("WAP");
		for (int i = 0; i < nbServiceWAP; i++) {
			wapType.addService(new ServiceImpl("WAP", i));
		}
		type.put("MMS", mmsType);
		type.put("WAP", wapType);
	}

	@Override
	public ServiceType getServiceType(String name) {
		return type.get(name);
	}

}

package com.ffrevol.gui.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("provisioning")
public interface ProvisioningService extends RemoteService {
	public String getProvisioning() throws IllegalArgumentException;;
	public String saveProvisioning(String data) throws IllegalArgumentException;;
}

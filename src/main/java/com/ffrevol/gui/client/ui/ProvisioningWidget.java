package com.ffrevol.gui.client.ui;

import com.google.gwt.user.client.ui.SimplePanel;

public class ProvisioningWidget extends SimplePanel
{

	private ProvisioningView prov;

	public ProvisioningWidget()
	{
		prov = new ProvisioningViewImpl();
		this.add(prov);
	}
	
	public ProvisioningView provisioningView() { return prov; };

}

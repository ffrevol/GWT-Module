package com.ffrevol.gui.client.ui;

import com.google.gwt.user.client.ui.IsWidget;


public interface ProvisioningView extends IsWidget, ServiceBaseView
{	
	void setProvisioning(String prov);
	String getProvisioning();
	public interface Presenter extends ServiceBaseView.Presenter
	{
		void load();
		void save(String data);
	}
	
}

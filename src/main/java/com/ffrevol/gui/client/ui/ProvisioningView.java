package com.ffrevol.gui.client.ui;

import com.google.gwt.user.client.ui.IsWidget;


public interface ProvisioningView extends IsWidget
{
	void setPresenter(Presenter listener);
	void setProvisioning(String prov);
	String getProvisioning();
	public interface Presenter
	{
		void load();
		void save(String data);
	}

	
}

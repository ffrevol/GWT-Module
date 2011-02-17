package com.ffrevol.gui.client.ui;

import com.google.gwt.user.client.ui.IsWidget;


public interface ProvisioningView extends IsWidget
{
	void setPresenter(Presenter listener);
	
	public interface Presenter
	{
		void load();
	}

	void setProvisioning(String prov);
}

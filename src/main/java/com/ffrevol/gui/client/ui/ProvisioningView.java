package com.ffrevol.gui.client.ui;

import java.util.List;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;


public interface ProvisioningView extends IsWidget, ServiceBaseView
{	
	void setProvisioning(String prov);
	String getProvisioning();
	
	void setServiceList(List<String> value);
	void setContext(String value);
	void setEditPanel(Panel edit);
	void setGrid(Grid grid);
	
	public interface Presenter extends ServiceBaseView.Presenter
	{
		void load();
		void save(String data);		
		void serviceType(String name);	
		boolean isReady();
	}
	
}

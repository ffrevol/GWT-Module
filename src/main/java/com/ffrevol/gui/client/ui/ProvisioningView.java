package com.ffrevol.gui.client.ui;

import java.util.List;

import com.ffrevol.gui.client.model.Service;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;


public interface ProvisioningView extends IsWidget, ServiceBaseView
{	
	void setProvisioning(String prov);
	String getProvisioning();
	
	void setServiceList(List<Service> value);
	void setContext(String value);	
	void setEdit(Service selected);
	void setGrid(List<Service> value);
	
	public interface Presenter extends ServiceBaseView.Presenter
	{
		void loadClicked();
		void saveClicked(String data);
		
		void serviceTypeClicked(String name);
		void serviceClicked(Service selected);		
	}

	
	
}

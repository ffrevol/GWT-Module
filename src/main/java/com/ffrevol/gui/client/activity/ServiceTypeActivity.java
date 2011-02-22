package com.ffrevol.gui.client.activity;

import com.ffrevol.gui.client.ClientFactory;
import com.ffrevol.gui.client.place.ServiceBasePlace;
import com.ffrevol.gui.client.ui.ProvisioningView;
import com.ffrevol.gui.client.ui.ServiceTypeView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ServiceTypeActivity extends ServiceBaseActivity
{

	public ServiceTypeActivity(ServiceBasePlace place,
			ClientFactory clientFactory)
	{
		super(place, clientFactory);
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus)
	{		
		ServiceTypeView typeView = getClientFactory().getServiceTypeView();
		typeView.setName(getName());
		typeView.setPresenter(this);
		containerWidget.setWidget(typeView.asWidget());
		
	}

}

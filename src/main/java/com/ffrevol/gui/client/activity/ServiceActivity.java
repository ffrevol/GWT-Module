package com.ffrevol.gui.client.activity;

import com.ffrevol.gui.client.ClientFactory;
import com.ffrevol.gui.client.place.ServiceBasePlace;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ServiceActivity extends ServiceBaseActivity
{

	public ServiceActivity(ServiceBasePlace place,
			ClientFactory clientFactory)
	{
		super(place, clientFactory);		
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus)
	{
		// TODO Auto-generated method stub

	}

}

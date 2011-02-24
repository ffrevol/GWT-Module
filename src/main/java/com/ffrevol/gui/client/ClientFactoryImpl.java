package com.ffrevol.gui.client;

import com.ffrevol.gui.client.ui.ProvisioningView;
import com.ffrevol.gui.client.ui.ProvisioningViewImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class ClientFactoryImpl implements ClientFactory
{
	private static final EventBus eventBus = new SimpleEventBus();
	private static final ProvisioningServiceAsync provService = GWT.create(ProvisioningService.class);
	private static final PlaceController placeController = new PlaceController(eventBus);
	private static final ProvisioningView provisioningView = new ProvisioningViewImpl();
	
	@Override
	public EventBus getEventBus()
	{
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController()
	{
		return placeController;
	}

	
		@Override
	public ProvisioningView getProvisioningView()
	{
		return provisioningView;
	}

	@Override
	public ProvisioningServiceAsync getProvisioningService()
	{
		return provService;
	}

}

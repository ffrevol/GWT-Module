package com.ffrevol.gui.client;

import com.ffrevol.gui.client.model.ProvisioningModel;
import com.ffrevol.gui.client.model.ProvisioningModelImpl;
import com.ffrevol.gui.client.ui.ProvisioningView;
import com.ffrevol.gui.client.ui.ProvisioningViewImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class ClientFactoryImpl implements ClientFactory
{
	private final EventBus eventBus = new SimpleEventBus();
	private final ProvisioningServiceAsync provService = GWT.create(ProvisioningService.class);
	private final PlaceController placeController = new PlaceController(eventBus);
	private final ProvisioningView provisioningView = new ProvisioningViewImpl();
	private final ProvisioningModel provModel = new ProvisioningModelImpl();
	
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

	@Override
	public ProvisioningModel getProvisioningModel() {
		return provModel ;
	}

}

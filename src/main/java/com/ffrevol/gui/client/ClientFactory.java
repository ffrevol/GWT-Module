package com.ffrevol.gui.client;

import com.ffrevol.gui.client.ui.ProvisioningView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

public interface ClientFactory
{
	EventBus getEventBus();
	ProvisioningServiceAsync getProvisioningService();
	PlaceController getPlaceController();
	ProvisioningView getProvisioningView();
}

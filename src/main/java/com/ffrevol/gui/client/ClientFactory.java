package com.ffrevol.gui.client;

import com.ffrevol.gui.client.ui.ServiceFilterView;
import com.ffrevol.gui.client.ui.ServiceTypeView;
import com.ffrevol.gui.client.ui.ServiceView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

public interface ClientFactory
{
	EventBus getEventBus();
	PlaceController getPlaceController();
	ServiceTypeView getServiceTypeView();
	ServiceView getServiceView();	
	ServiceFilterView getServiceFilterView();
}

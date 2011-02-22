package com.ffrevol.gui.client.activity;

import com.ffrevol.gui.client.ClientFactory;
import com.ffrevol.gui.client.place.ServiceBasePlace;
import com.ffrevol.gui.client.ui.ServiceBaseView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public abstract class ServiceBaseActivity extends AbstractActivity implements
ServiceBaseView.Presenter {
	// Used to obtain views, eventBus, placeController
	// Alternatively, could be injected via GIN
	private ClientFactory clientFactory;
	public ClientFactory getClientFactory()
	{
		return clientFactory;
	}

	public String getName()
	{
		return name;
	}

	// Name that will be appended to "Hello,"
	private String name;

	public ServiceBaseActivity(ServiceBasePlace place, ClientFactory clientFactory) {
		this.name = place.getName();
		this.clientFactory = clientFactory;
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	abstract public void start(AcceptsOneWidget containerWidget, EventBus eventBus);
		

	/**
	 * Ask user before stopping this activity
	 */
	@Override
//	public String mayStop() {
//		return name + ":"+ "Please hold on. This activity is stopping.";
//	}

	/**
	 * Navigate to a new Place in the browser
	 */
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}
}

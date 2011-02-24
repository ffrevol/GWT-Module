package com.ffrevol.gui.client.mvp;

import com.ffrevol.gui.client.ClientFactory;
import com.ffrevol.gui.client.activity.ProvisioningActivity;
import com.ffrevol.gui.client.place.ProvisioningPlace;
import com.ffrevol.gui.client.place.ServiceBasePlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	/**
	 * AppActivityMapper associates each Place with its corresponding
	 * {@link Activity}
	 * 
	 * @param clientFactory
	 *            Factory to be passed to activities
	 */
	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	/**
	 * Map each Place to its corresponding Activity. This would be a great use
	 * for GIN.
	 */
	@Override
	public Activity getActivity(Place place) {
		// This is begging for GIN
		if (place instanceof ProvisioningPlace)
			return new ProvisioningActivity((ServiceBasePlace) place, clientFactory);
		return null;
	}

}

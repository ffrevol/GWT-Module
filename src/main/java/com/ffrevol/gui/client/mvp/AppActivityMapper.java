package com.ffrevol.gui.client.mvp;

import com.ffrevol.gui.client.ClientFactory;
import com.ffrevol.gui.client.activity.ProvisioningActivity;
import com.ffrevol.gui.client.activity.ServiceActivity;
import com.ffrevol.gui.client.activity.ServiceFilterActivity;
import com.ffrevol.gui.client.activity.ServiceTypeActivity;
import com.ffrevol.gui.client.place.ProvisioningPlace;
import com.ffrevol.gui.client.place.ServiceBasePlace;
import com.ffrevol.gui.client.place.ServiceFilterPlace;
import com.ffrevol.gui.client.place.ServicePlace;
import com.ffrevol.gui.client.place.ServiceTypePlace;
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
		else if (place instanceof ServiceTypePlace)
			return new ServiceTypeActivity((ServiceBasePlace) place, clientFactory);
		else if (place instanceof ServicePlace)
			return new ServiceActivity((ServiceBasePlace) place, clientFactory);
		else if (place instanceof ServiceFilterPlace)
			return new ServiceFilterActivity((ServiceBasePlace) place, clientFactory);

		return null;
	}

}

package com.ffrevol.gui.client.ui;

import com.ffrevol.gui.client.activity.ServiceBaseActivity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface ServiceBaseView extends IsWidget
{

	public interface Presenter
	{
		void goTo(Place place);
	}

	void setName(String name);

	void setPresenter(ServiceBaseActivity serviceActivity);

}

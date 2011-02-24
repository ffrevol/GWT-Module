package com.ffrevol.gui.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface ServiceBaseView extends IsWidget
{

	public interface Presenter
	{
		void goTo(Place place);
	}
		
	void setPresenter(Presenter listener);

}

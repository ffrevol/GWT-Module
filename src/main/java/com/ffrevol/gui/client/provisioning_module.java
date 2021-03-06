package com.ffrevol.gui.client;

import com.ffrevol.gui.client.mvp.AppActivityMapper;
import com.ffrevol.gui.client.mvp.AppPlaceHistoryMapper;
import com.ffrevol.gui.client.place.ProvisioningPlace;
import com.ffrevol.gui.client.ui.ProvisioningWidget;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class provisioning_module implements EntryPoint {
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  
  private ProvisioningWidget appWidget = new ProvisioningWidget();
  private Place defaultPlace = new ProvisioningPlace("WAP");
  
  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	// Create ClientFactory using deferred binding so we can replace with different
		// impls in gwt.xml
		ClientFactory clientFactory = GWT.create(ClientFactory.class);
		EventBus eventBus = clientFactory.getEventBus();		

		// Start ActivityManager for the main widget with our ActivityMapper
		ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(appWidget);

		//clientFactory.getPlaceController().goTo(defaultPlace);
		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(clientFactory.getPlaceController(), eventBus, defaultPlace);

//		ProvisioningView.Presenter presenter = new ProvisioningPresenterImpl(this);
		RootPanel.get().add(appWidget);
//		appWidget.setPresenter(presenter);
		// Goes to place represented on URL or default place
		historyHandler.handleCurrentHistory();
  }
}

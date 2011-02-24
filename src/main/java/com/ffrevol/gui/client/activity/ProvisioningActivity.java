package com.ffrevol.gui.client.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.ffrevol.gui.client.ClientFactory;
import com.ffrevol.gui.client.place.ServiceBasePlace;
import com.ffrevol.gui.client.ui.ProvisioningView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ProvisioningActivity extends ServiceBaseActivity implements ProvisioningView.Presenter
{
	private Logger logger = Logger.getLogger(ProvisioningActivity.class.getName());


	public ProvisioningActivity(ServiceBasePlace place,
			ClientFactory clientFactory)
	{
		super(place, clientFactory);
	}

	@Override
	public void load()
	{
		AsyncCallback<String> callback = new AsyncCallback<String>()
		{
			
			@Override
			public void onSuccess(String result)
			{
				logger.severe("provisioning get succeed");
				getClientFactory().getProvisioningView().setProvisioning(result);
			}
			
			@Override
			public void onFailure(Throwable caught)
			{
				logger.severe("provisioning get failed");
				getClientFactory().getProvisioningView().setProvisioning(caught.getLocalizedMessage());
				
			}
		};
		getClientFactory().getProvisioningService().getProvisioning(callback);		
	}
	
	@Override
	public void save(String data)
	{
		AsyncCallback<String> callback = new AsyncCallback<String>()
		{
			
			@Override
			public void onSuccess(String result)
			{
				logger.severe("provisioning set succeed");				
			}
			
			@Override
			public void onFailure(Throwable caught)
			{
				logger.severe("provisioning set failed");				
			}
		};
		getClientFactory().getProvisioningService().saveProvisioning(data, callback);
		
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus)
	{
		ProvisioningView provView = getClientFactory().getProvisioningView();		
		serviceType(getName());
		provView.setPresenter(this);
		containerWidget.setWidget(provView.asWidget());
		
	}

	@Override
	public void serviceType(String name)
	{
		getClientFactory().getProvisioningView().setContext(name);
		List<String> listService = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
		getClientFactory().getProvisioningView().setServiceList(listService);
	}	
}

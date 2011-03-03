package com.ffrevol.gui.client.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import com.ffrevol.gui.client.ClientFactory;
import com.ffrevol.gui.client.model.ProvisioningI;
import com.ffrevol.gui.client.model.ProvisioningModel;
import com.ffrevol.gui.client.model.SegmentI;
import com.ffrevol.gui.client.model.ServiceI;
import com.ffrevol.gui.client.place.ServiceBasePlace;
import com.ffrevol.gui.client.ui.ProvisioningView;
import com.ffrevol.gui.tools.LogFactory;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ProvisioningActivity extends ServiceBaseActivity implements ProvisioningView.Presenter
{
	private Logger logger = LogFactory.getLogger();
	private ProvisioningI provisioningModel = new ProvisioningModel();
	private boolean isReady = false;

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
				initializedModel(result);
				logger.severe("provisioning set Provisioning view");
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
	
	protected void initializedModel(String result)
	{
		getClientFactory().getProvisioningParser().Parse(provisioningModel, result);	
		isReady = true;
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
		if(isReady())
		{
			SegmentI segment = provisioningModel.getSegment(name);
			List<ServiceI> listService = segment.Service();
			List<String> listServiceName = new ArrayList<String>();
			for(ServiceI svc : listService)
			{
				logger.info("Add in serviceList :" + svc.Name());
				listServiceName.add(svc.Name());
			}		
			getClientFactory().getProvisioningView().setServiceList(listServiceName);
		}
		else {
			logger.severe("Model is not ready");
		}
	}

	@Override
	public boolean isReady() {
		return isReady;
	}	
}

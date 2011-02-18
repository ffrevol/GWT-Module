package com.ffrevol.gui.client.activity;

import java.util.logging.Logger;

import com.ffrevol.gui.client.provisioning_module;
import com.ffrevol.gui.client.ui.ProvisioningView.Presenter;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ProvisioningPresenterImpl implements Presenter, AsyncCallback<String>
{

	private final provisioning_module provisioningModule;	
	private Logger logger = Logger.getLogger(ProvisioningPresenterImpl.class.getName());

	public ProvisioningPresenterImpl(provisioning_module provisioningModule)
	{
		this.provisioningModule = provisioningModule;
	}

	@Override
	public void load()
	{
		provisioningModule.provisioningService().getProvisioning(this);		
	}

	@Override
	public void onFailure(Throwable caught)
	{
		logger.severe("provisioning get failed");
		provisioningModule.provisioningView().setProvisioning(caught.getLocalizedMessage());
		
	}

	@Override
	public void onSuccess(String result)
	{
		logger.severe("provisioning get succeed");
		provisioningModule.provisioningView().setProvisioning(result);		
	}

}

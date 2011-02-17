package com.ffrevol.gui.client.activity;

import com.ffrevol.gui.client.provisioning_module;
import com.ffrevol.gui.client.ui.ProvisioningView.Presenter;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ProvisioningPresenterImpl implements Presenter, AsyncCallback<String>
{

	private final provisioning_module provisioningModule;

	public ProvisioningPresenterImpl(provisioning_module provisioningModule)
	{
		this.provisioningModule = provisioningModule;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void load()
	{
		provisioningModule.provisioningService().getProvisioning(this);		
	}

	@Override
	public void onFailure(Throwable caught)
	{
		provisioningModule.provisioningView().setProvisioning(caught.getLocalizedMessage());
		
	}

	@Override
	public void onSuccess(String result)
	{
		provisioningModule.provisioningView().setProvisioning(result);		
	}

}

package com.ffrevol.gui.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class Provisioning_moduleTestGwt  extends GWTTestCase  {

	private AsyncCallback<String> callback;	
	private ProvisioningServiceAsync provService;
	 /**
	   * Must refer to a valid module that sources this class.
	   */
	  public String getModuleName() {
		  return "com.ffrevol.gui.provisioning_moduleJUnit";
	  }
	  
	  public void gwtSetUp () {
		provService = GWT.create(ProvisioningService.class);
		    ServiceDefTarget target = (ServiceDefTarget) provService;
		    target.setServiceEntryPoint(GWT.getModuleBaseURL() + "provisioning_module/provisioning");
		    
		  
	  }
	  public void gwtTearDown() {		
	  }

	  public void testPostRequest()
		{
			delayTestFinish(3000);
			String data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<provisioning></provisioning>";
			callback = new AsyncCallback<String>() {

				@Override
				public void onSuccess(String result) {
					GWT.log("onSuccess : " + result);
					assertTrue(result, result.equals(""));
					finishTest();				
				}

				@Override
				public void onFailure(Throwable caught)
				{
					GWT.log("onFailure : " + caught.getLocalizedMessage());
					fail("Request failure: " + caught);	
				}};		
			provService.saveProvisioning(data, callback);
		}
	  public void testGetRequest()
	{		
		delayTestFinish(3000); 	 
		callback = new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				GWT.log("onSuccess : " + result);
				assertTrue(result, result.startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"));
				finishTest();				
			}

			@Override
			public void onFailure(Throwable caught)
			{
				GWT.log("onFailure : " + caught.getLocalizedMessage());
				fail("Request failure: " + caught);	
			}};		
	    provService.getProvisioning(callback);		
	}
	
}

package com.ffrevol.gui.client;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.ffrevol.gui.client.activity.ProvisioningActivity;
import com.ffrevol.gui.client.model.ProvisioningModel;
import com.ffrevol.gui.client.model.ProvisioningModelImpl;
import com.ffrevol.gui.client.place.ServiceBasePlace;
import com.ffrevol.gui.client.ui.ProvisioningView;
import com.google.gwt.user.client.rpc.AsyncCallback;


public class ProvisioningPresenterTest {

	private ProvisioningView mockView;
	private ClientFactory clientFactory;
	private ServiceBasePlace place;
	private ProvisioningActivity activity;
	private ProvisioningServiceAsync service;

	public void init()
	{	
		mockView = mock(ProvisioningView.class);
		clientFactory = mock(ClientFactory.class);
		place = mock(ServiceBasePlace.class);
		service = mock(ProvisioningServiceAsync.class);
		activity = new ProvisioningActivity(place, clientFactory);
		
		when(clientFactory.getProvisioningView()).thenReturn(mockView);
		when(clientFactory.getProvisioningService()).thenReturn(service);
	}
	
	@Test
	public void onLoadProvisioningEmty() 
	{
		init();
		doAnswer(new Answer() {
		      public Object answer(InvocationOnMock invocation) {
		          Object[] args = invocation.getArguments();
		          AsyncCallback<java.lang.String> callback = (AsyncCallback<String>) args[0];
		          callback.onSuccess("");		          
		          return null;
		      }})
		  .when(service).getProvisioning(any(AsyncCallback.class));		 
		activity.loadClicked();		
		verify(mockView, times(1)).setProvisioning("");
	}
	@Test
	public void onLoadProvisioningNonEmty() throws Exception {
		init();
		doAnswer(new Answer() {
		      public Object answer(InvocationOnMock invocation) {
		          Object[] args = invocation.getArguments();
		          AsyncCallback<java.lang.String> callback = (AsyncCallback<String>) args[0];
		          callback.onSuccess("ttttttttttttttt");		          
		          return null;
		      }})
		  .when(service).getProvisioning(any(AsyncCallback.class));		 
		activity.loadClicked();		
		verify(mockView, times(1)).setProvisioning("ttttttttttttttt");
	}
	
	@Test
	public void onServiceTypeClicked() throws Exception {
		init();
		String type = "MMS";
		ProvisioningModel model = new ProvisioningModelImpl();
		//given
		given(clientFactory.getProvisioningModel()).willReturn(model);		
		//when
		activity.serviceTypeClicked(type);
		//then
		verify(mockView, times(1)).setContext(type);
		verify(mockView, times(1)).setServiceList(model.getServiceType(type).getService());		
	}
}

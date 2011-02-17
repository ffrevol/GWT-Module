package com.ffrevol.gui.service;

import com.ffrevol.gui.tools.LogFactory;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestTimeoutException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.rpc.AsyncCallback;

class RequestCallbackImpl implements RequestCallback {

	private static final int STATUS_CODE_OK = 200;
	private final AsyncCallback<String> callback;

	  public RequestCallbackImpl(AsyncCallback<String> _callback) {
		callback = _callback;
	}

	public void onError(Request request, Throwable exception) {
	    if (exception instanceof RequestTimeoutException) {	    	
	    	LogFactory.getLogger().severe("request timeout");
	      
	    } else {
	    	LogFactory.getLogger().severe("request error : " + exception.getMessage());
	    }
	    callback.onFailure(exception);
	  }

	  public void onResponseReceived(Request request, Response response) 
	  {
	    if (STATUS_CODE_OK == response.getStatusCode()) {
	    	callback.onSuccess(response.getText());
	    } else {	    	  
	    	LogFactory.getLogger().severe("error responce code : " + response.getStatusCode());		      
		      callback.onFailure(new Throwable(response.getStatusCode() +
		    		  	": "+ response.getStatusText()));
	    }
	  }
	}


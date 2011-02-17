package com.ffrevol.gui.service;

import com.ffrevol.gui.tools.LogFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class HTTPUtilityImpl implements HTTPUtility {
	
	private  int requestTimeout = 5000;

	public  void setRequestTimeout(int _requestTimeout) {
		requestTimeout = _requestTimeout;
	}

	public HTTPUtilityImpl()
	{
		LogFactory.getLogger().info("new HTTPUtilityImpl");	
	}

	public void doGet(String url, AsyncCallback<String> callback) {		
		String real_url = ProcessedUrl(url);
		LogFactory.getLogger().info("Get : " + real_url);		
	    RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, real_url);
	    builder.setTimeoutMillis(requestTimeout );
	    try {
	      Request request = builder.sendRequest(null, new RequestCallbackImpl(callback));	      
	    } catch (RequestException e) {
	      callback.onFailure(e);
	      LogFactory.getLogger().severe(e.getMessage());
	    }
	  }

	private static String ProcessedUrl(String url) {
		String real_url = GWT.getModuleBaseURL() + URL.encode(url);
		return real_url;
	}

	public void doPost(String url, String data,
			AsyncCallback<String> callback) {
		String real_url = ProcessedUrl(url);
		LogFactory.getLogger().info("Post : " + real_url);
		RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, real_url);
		
		try {
		      //builder.setHeader("Content-Type", "application/x-www-form-urlencoded");
			  builder.setHeader("Content-Type", "multipart/form-data");
		      Request response = builder.sendRequest(URL.encodeQueryString(data), 
		    		  	new RequestCallbackImpl(callback));
		    } catch (RequestException e) {
		    	callback.onFailure(e);
		    	LogFactory.getLogger().severe(e.getMessage());
		    }
		  }
	}

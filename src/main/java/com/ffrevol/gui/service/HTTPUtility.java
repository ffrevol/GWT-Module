package com.ffrevol.gui.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HTTPUtility
{

	void doGet(String url, AsyncCallback<String>  callback);

	void doPost(String urlSave, String data, AsyncCallback<String>  callback);

}

package com.ffrevol.gui.tools;

import com.ffrevol.gui.client.model.Service;


public class ServiceToNameFunction implements com.ffrevol.gui.tools.Function<Service, String> {

	@Override
	public String apply(Service arg0) {
		return arg0.Name();
	}


}

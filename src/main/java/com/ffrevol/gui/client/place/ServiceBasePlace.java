package com.ffrevol.gui.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

//public class HelloPlace extends ActivityPlace<HelloActivity>
public class ServiceBasePlace extends Place
{
	private String helloName;
	
	public ServiceBasePlace(String token)
	{
		this.helloName = token;
	}

	public String getName()
	{
		return helloName;
	}

	public static class Tokenizer implements PlaceTokenizer<ServiceBasePlace>
	{

		@Override
		public String getToken(ServiceBasePlace place)
		{
			return place.getName();
		}

		@Override
		public ServiceBasePlace getPlace(String token)
		{
			return new ServiceBasePlace(token);
		}

	}
	
//	@Override
//	protected Place getPlace(String token)
//	{
//		return new HelloPlace(token);
//	}
//
//	@Override
//	protected Activity getActivity()
//	{
//		return new HelloActivity("David");
//	}
}

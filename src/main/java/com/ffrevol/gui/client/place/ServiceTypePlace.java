package com.ffrevol.gui.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

//public class HelloPlace extends ActivityPlace<HelloActivity>
public class ServiceTypePlace extends Place
{
	private String helloName;
	
	public ServiceTypePlace(String token)
	{
		this.helloName = token;
	}

	public String getHelloName()
	{
		return helloName;
	}

	public static class Tokenizer implements PlaceTokenizer<ServiceTypePlace>
	{

		@Override
		public String getToken(ServiceTypePlace place)
		{
			return place.getHelloName();
		}

		@Override
		public ServiceTypePlace getPlace(String token)
		{
			return new ServiceTypePlace(token);
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

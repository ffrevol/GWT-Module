package com.ffrevol.gui.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

//public class HelloPlace extends ActivityPlace<HelloActivity>
public class ServicePlace extends Place
{
	private String helloName;
	
	public ServicePlace(String token)
	{
		this.helloName = token;
	}

	public String getHelloName()
	{
		return helloName;
	}

	public static class Tokenizer implements PlaceTokenizer<ServicePlace>
	{

		@Override
		public String getToken(ServicePlace place)
		{
			return place.getHelloName();
		}

		@Override
		public ServicePlace getPlace(String token)
		{
			return new ServicePlace(token);
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

package com.ffrevol.gui.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

//public class HelloPlace extends ActivityPlace<HelloActivity>
public class ServiceFilterPlace extends Place
{
	private String helloName;
	
	public ServiceFilterPlace(String token)
	{
		this.helloName = token;
	}

	public String getHelloName()
	{
		return helloName;
	}

	public static class Tokenizer implements PlaceTokenizer<ServiceFilterPlace>
	{

		@Override
		public String getToken(ServiceFilterPlace place)
		{
			return place.getHelloName();
		}

		@Override
		public ServiceFilterPlace getPlace(String token)
		{
			return new ServiceFilterPlace(token);
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

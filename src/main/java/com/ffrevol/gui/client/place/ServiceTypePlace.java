package com.ffrevol.gui.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;

public class ServiceTypePlace extends ServiceBasePlace
{
	
	public ServiceTypePlace(String token)
	{
		super(token);		
	}

	public static class Tokenizer implements PlaceTokenizer<ServiceTypePlace>
	{

		@Override
		public String getToken(ServiceTypePlace place)
		{
			return place.getName();
		}

		@Override
		public ServiceTypePlace getPlace(String token)
		{
			return new ServiceTypePlace(token);
		}

	}
}

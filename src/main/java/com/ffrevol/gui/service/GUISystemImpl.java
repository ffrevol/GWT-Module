package com.ffrevol.gui.service;

public class GUISystemImpl implements GUISystem
{
	private final HTTPUtility httpUtility = new HTTPUtilityImpl();

	public com.ffrevol.gui.service.HTTPUtility HTTPUtility()
	{
		return httpUtility ;
	}

}

package com.ffrevol.gui.client.ui;

import java.util.logging.Logger;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ServiceTypeViewImpl extends Composite implements ServiceTypeView
{

	private String serviceTypeName;
	private Presenter serviceTypeActivity;
	private Label svcTypeValue;
	private Logger logger = Logger.getLogger(ServiceTypeViewImpl.class.getName());

	@Override
	public void setName(String name)
	{
		this.serviceTypeName = name;
		svcTypeValue.setText(serviceTypeName);
	}

	public ServiceTypeViewImpl()
	{
		HorizontalPanel panel = new HorizontalPanel();		
		Label svcType = new Label("serviceType : ");
		panel.add(svcType);
		panel.addStyleName("ffrevol_coloredbackground");
		svcTypeValue = new Label("unknown");
		panel.add(svcTypeValue);
		initWidget(panel);
		logger.info("initialized with " + serviceTypeName);
	}

	@Override
	public void setPresenter(Presenter serviceTypeActivity)
	{
		this.serviceTypeActivity = serviceTypeActivity;
	}

	@Override
	public Widget asWidget()
	{
		return this;
	}

}

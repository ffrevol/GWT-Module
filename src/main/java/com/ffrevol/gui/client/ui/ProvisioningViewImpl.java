package com.ffrevol.gui.client.ui;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.ffrevol.gui.client.place.ServiceTypePlace;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProvisioningViewImpl extends Composite implements ProvisioningView
{

	private Presenter presenter;
	private TextArea textArea;
	private Logger logger = Logger.getLogger(ProvisioningViewImpl.class.getName());

	public ProvisioningViewImpl()
	{
		
		VerticalPanel panel = new VerticalPanel();		
		Button btnLoadbutton = new Button("Load_button");
		panel.add(btnLoadbutton);
		btnLoadbutton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				presenter.load();
			}
		});
		btnLoadbutton.setText("Load");
		Button btnSavebutton = new Button("Save_button");
		panel.add(btnSavebutton);
		btnSavebutton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				presenter.save(getProvisioning());
				presenter.goTo(new ServiceTypePlace("MMS"));
			}
		});
		btnSavebutton.setText("Save");
		textArea = new TextArea();
		textArea.setSize("200", "120");
		textArea.setHeight("100%");
		textArea.setWidth("100%");
		panel.add(textArea);
		Label lblCompany = new Label("Company");
		panel.add(lblCompany);
		initWidget(panel);
		logger.info("initialized ");
	}

	@Override
	public void setProvisioning(String prov)
	{
		
	    logger.log(Level.SEVERE, "receive prov : " + prov);
		textArea.setText(prov);
	}

	@Override
	public String getProvisioning()
	{
		return textArea.getValue();
	}

	@Override
	public void setName(String name)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPresenter(
			com.ffrevol.gui.client.ui.ServiceBaseView.Presenter listener)
	{
		this.presenter = (Presenter) listener;		
		
	}

}

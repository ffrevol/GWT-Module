package com.ffrevol.gui.client.ui;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProvisioningComposite extends Composite implements ProvisioningView
{

	private Presenter presenter;
	private TextArea textArea;
	private Logger logger = Logger.getLogger(ProvisioningComposite.class.getName());

	public ProvisioningComposite()
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
		textArea = new TextArea();
		textArea.setSize("200", "120");
		textArea.setHeight("100%");
		textArea.setWidth("100%");
		panel.add(textArea);
		Label lblCompany = new Label("Company");
		panel.add(lblCompany);
		initWidget(panel);
	}

	@Override
	public void setPresenter(Presenter listener)
	{
		this.presenter = listener;		
	}

	@Override
	public void setProvisioning(String prov)
	{
		
	    logger.log(Level.SEVERE, "receive prov : " + prov);
		textArea.setText(prov);
	}

}

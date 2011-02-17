package com.ffrevol.gui.client.ui;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class ProvisioningComposite extends Composite implements ProvisioningView
{

	private Presenter presenter;
	private TextArea textArea;

	public ProvisioningComposite()
	{
		
		DockLayoutPanel dockLayoutPanel = new DockLayoutPanel(Unit.EM);		
		SplitLayoutPanel splitLayoutPanel = new SplitLayoutPanel();
		Button btnLoadbutton = new Button("Load_button");
		btnLoadbutton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				presenter.load();
			}
		});
		btnLoadbutton.setText("Load");
		splitLayoutPanel.addWest(btnLoadbutton, 1.0);
		
		textArea = new TextArea();
		dockLayoutPanel.addNorth(splitLayoutPanel, 7.5);
		dockLayoutPanel.add(textArea);
		initWidget(dockLayoutPanel);		
	}

	@Override
	public void setPresenter(Presenter listener)
	{
		this.presenter = listener;		
	}

	@Override
	public void setProvisioning(String prov)
	{
		textArea.setText(prov);
	}

}

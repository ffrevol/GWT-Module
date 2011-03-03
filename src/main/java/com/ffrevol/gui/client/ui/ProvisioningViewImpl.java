package com.ffrevol.gui.client.ui;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ffrevol.gui.tools.LogFactory;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProvisioningViewImpl extends Composite implements ProvisioningView
{

	private Presenter presenter;
	private TextArea textArea;
	private Logger logger = LogFactory.getLogger();
	private final ContextUI context;
	private final CellList<String> listCell;
	private Panel editPanel;
	private Panel gridPanel;

	public ProvisioningViewImpl()
	{
		VerticalPanel verticalPanel = new VerticalPanel();		
		verticalPanel.setSize("100%", "100%");
		
		HorizontalPanel topPanel = new HorizontalPanel();
		verticalPanel.add(topPanel);
		Button btnLoadbutton = new Button("Load_button");
		topPanel.add(btnLoadbutton);
		btnLoadbutton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				presenter.load();
			}
		});
		btnLoadbutton.setText("Load");
		Button btnSavebutton = new Button("Save_button");
		topPanel.add(btnSavebutton);
		btnSavebutton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				presenter.save(getProvisioning());				
			}
		});
		btnSavebutton.setText("Save");
		
		HorizontalPanel typePanel = new HorizontalPanel();
		verticalPanel.add(typePanel);
		final Button mmsButton = new Button("MMS");
		typePanel.add(mmsButton);
		mmsButton.addClickHandler(new ClickHandler()
		{	
			@Override
			public void onClick(ClickEvent event)
			{
				presenter.serviceType(mmsButton.getText());
			}
		});
		final Button wapButton = new Button("WAP");
		typePanel.add(wapButton);
		wapButton.addClickHandler(new ClickHandler()
		{	
			@Override
			public void onClick(ClickEvent event)
			{
				presenter.serviceType(wapButton.getText());
			}
		});
		
		HorizontalPanel bodyPanel = new HorizontalPanel();
		verticalPanel.add(bodyPanel);
		
		VerticalPanel leftBodyPanel = new VerticalPanel();
		bodyPanel.add(leftBodyPanel);		
		
		Label listType = new Label("List Name");
		leftBodyPanel.add(listType);
		
		TextCell textCell = new TextCell();
		listCell = new CellList<String>(textCell);
		leftBodyPanel.add(listCell);		
		VerticalPanel rightBodyPanel = new VerticalPanel();
		bodyPanel.add(rightBodyPanel);	
		context = new ContextUIImpl();
		rightBodyPanel.add(context);
		editPanel = new SimplePanel();
		rightBodyPanel.add(editPanel);
		gridPanel = new SimplePanel();
		rightBodyPanel.add(gridPanel);
		
		HorizontalPanel bottomPanel = new HorizontalPanel();
		verticalPanel.add(bottomPanel);
		
		textArea = new TextArea();
		textArea.setSize("200", "120");
		textArea.setHeight("100%");
		textArea.setWidth("100%");
		bottomPanel.add(textArea);
		Label lblCompany = new Label("Company");
		bottomPanel.add(lblCompany);
		initWidget(verticalPanel);
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
	public void setPresenter(
			com.ffrevol.gui.client.ui.ServiceBaseView.Presenter listener)
	{
		this.presenter = (Presenter) listener;		
	}

	@Override
	public void setContext(String value)
	{
		context.setContext(value);
	}

	@Override
	public void setEditPanel(Panel edit)
	{
		editPanel = edit;		
	}

	@Override
	public void setGrid(Grid grid)
	{
		gridPanel = grid;		
	}

	@Override
	public void setServiceList(List<String> values)
	{
		listCell.setRowData(0, values);
	}

}

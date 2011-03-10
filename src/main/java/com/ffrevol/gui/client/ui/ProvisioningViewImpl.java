package com.ffrevol.gui.client.ui;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ffrevol.gui.client.model.Service;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

public class ProvisioningViewImpl extends Composite implements ProvisioningView
{

	private Presenter presenter;
	private TextArea textArea;
	private Logger logger = Logger.getLogger(ProvisioningViewImpl.class.getName());
	private final ContextUI context;
	private final CellList<Service> listCell;
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
				presenter.loadClicked();
			}
		});
		btnLoadbutton.setText("Load");
		Button btnSavebutton = new Button("Save_button");
		topPanel.add(btnSavebutton);
		btnSavebutton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				presenter.saveClicked(getProvisioning());				
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
				presenter.serviceTypeClicked(mmsButton.getText());
			}
		});
		final Button wapButton = new Button("WAP");
		typePanel.add(wapButton);
		wapButton.addClickHandler(new ClickHandler()
		{	
			@Override
			public void onClick(ClickEvent event)
			{
				presenter.serviceTypeClicked(wapButton.getText());
			}
		});
		
		HorizontalPanel bodyPanel = new HorizontalPanel();
		verticalPanel.add(bodyPanel);
		
		VerticalPanel leftBodyPanel = new VerticalPanel();
		bodyPanel.add(leftBodyPanel);		
		
		Label listType = new Label("List Name");
		leftBodyPanel.add(listType);
		
		Cell<Service> serviceCell = new ServiceCell();
		listCell = new CellList<Service>(serviceCell);
		listCell.setPageSize(30);
		listCell.setKeyboardPagingPolicy(KeyboardPagingPolicy.INCREASE_RANGE);
		listCell.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);

		    // Add a selection model so we can select cells.
		final SingleSelectionModel<Service> selectionModel = new SingleSelectionModel<Service>();

	    listCell.setSelectionModel(selectionModel);
	    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
	      public void onSelectionChange(SelectionChangeEvent event) {
	    	  presenter.serviceClicked(selectionModel.getSelectedObject());
	      }
	    });

		
		
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

	
	private void setEditPanel(Panel edit)
	{
		editPanel.clear();
		editPanel.add(edit);		
	}

	@Override
	public void setServiceList(List<Service> values)
	{	
		listCell.setRowCount(0, true);
		listCell.setRowData(0, values);
	}
	
	private void setGrid(CellTable<?> table) {
		gridPanel.clear();
		gridPanel.add(table);
	}

	@Override
	public void setEdit(Service selected) {
		Panel edit = new EditService(selected);
		setEditPanel(edit);
	}

	@Override
	public void setGrid(List<Service> value) {
		ServiceTable table = new ServiceTable(presenter, value);		
		setGrid(table);
	}

}

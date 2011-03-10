package com.ffrevol.gui.client.ui;

import java.util.List;

import com.ffrevol.gui.client.ClientFactory;
import com.ffrevol.gui.client.activity.ProvisioningActivity;
import com.ffrevol.gui.client.model.Service;
import com.ffrevol.gui.client.ui.ProvisioningView.Presenter;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

public class ServiceTable extends CellTable<Service> {

	private final List<Service> listService;
	private final Presenter presenter;

	public ServiceTable(Presenter _presenter, List<Service> _listService) {
		this.presenter = _presenter;
		this.listService = _listService;
		TextColumn<Service> nameColumn = new TextColumn<Service>() {
			@Override
			public String getValue(Service object) {
				return object.Name();
			}
		};
		this.addColumn(nameColumn, "Name");
		TextColumn<Service> idColumn = new TextColumn<Service>() {
			@Override
			public String getValue(Service object) {
				return object.Id();
			}
		};
		this.addColumn(idColumn, "Id");

		// Add a selection model to handle user selection.
		final SingleSelectionModel<Service> selectionModel = new SingleSelectionModel<Service>();
		this.setSelectionModel(selectionModel);
		selectionModel
				.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
					public void onSelectionChange(SelectionChangeEvent event) {
						Service selected = selectionModel.getSelectedObject();
						if (selected != null) {
							presenter.serviceClicked(selected);
						}
					}
				});

		// Set the total row count. This isn't strictly necessary, but it
		// affects
		// paging calculations, so its good habit to keep the row count up to
		// date.
		this.setRowCount(listService.size(), true);

		// Push the data into the widget.
		this.setRowData(0, listService);
	}

}

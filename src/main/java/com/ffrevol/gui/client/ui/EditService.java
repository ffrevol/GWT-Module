package com.ffrevol.gui.client.ui;

import com.ffrevol.gui.client.model.Service;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditService extends SimplePanel {

	private final Service service;
	private VerticalPanel panel;

	public EditService(Service _first) {
		this.service = _first;
		init();
	}

	private void init() {
		panel = new VerticalPanel();
		addEntry("Service Name", service.Name());
		addEntry("Service Id", service.Id());	
		this.add(panel);
	}

	private void addEntry(String name, String value) {
		Label nameLabel = new Label(name);
		TextBox valueText = new TextBox();
		valueText.setText(value);
		panel.add(nameLabel);
		panel.add(valueText);
	}


}

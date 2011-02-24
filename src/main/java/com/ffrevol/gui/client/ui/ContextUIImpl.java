package com.ffrevol.gui.client.ui;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class ContextUIImpl extends HorizontalPanel implements ContextUI
{

	private Label value;

	public ContextUIImpl()
	{
		super();
		Label context = new Label("Context : ");
		value = new Label();
		this.add(context);
		this.add(value);
	}

	@Override
	public void setContext(String _context)
	{
		value.setText(_context);
		
	}

}

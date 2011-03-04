package com.ffrevol.gui.client.ui;

import com.ffrevol.gui.client.model.Service;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class ServiceCell extends AbstractCell<Service>
{
	@Override
	public void render(Service value, Object key, SafeHtmlBuilder sb) {
	 // Value can be null, so do a null check..
    if (value == null) {
      return;
    }
    sb.appendHtmlConstant(value.Name());

	}

}

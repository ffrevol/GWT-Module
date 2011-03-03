package com.ffrevol.gui.client.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;

public class ProvisioningModel implements ProvisioningI {

	private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";	
	private List<SegmentI> list = new LinkedList<SegmentI>();
	private Document document;
	
	@Override
	public void AddSegment(SegmentI segment) {
		list.add(segment);
	}

	@Override
	public SegmentI RemoveSegment(SegmentI segment) {
		return list.remove(segment) ? segment : null;
	}

	@Override
	public List<SegmentI> Segment() {
		return list;
	}

	@Override
	public String XMLStringValue() {
		String result = XML_HEADER;
		result += _XMLStringValue();		
		return result;
	}

	private String _XMLStringValue() {
		if(document == null) return "";
		return document.toString();
	}
	
	@Override
	public Element getElement() {
		 return document.getDocumentElement();
	}

	@Override
	public void setElement(Document _messageDom) {
		document = _messageDom;
	}

	@Override
	public SegmentI getSegment(String name) {
		for (Iterator<SegmentI> iterator = list.iterator(); iterator.hasNext();)
		{
			SegmentI segment = (SegmentI) iterator.next();
			if(segment.Name().equals(name)) 
			{
				return segment; 
			}
		}
		assert true : "Segment " + name + " not found";
		return null;
	}

}

package com.ffrevol.gui.client.model;

import com.ffrevol.gui.tools.LogFactory;
import com.google.gwt.xml.client.DOMException;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.XMLParser;

public class FredXMLParser {

	public void Parse(String xml) {
		try {
		    // parse the XML document into a DOM
		    Document messageDom = XMLParser.parse(xml);
		    ParseByTagName(messageDom, "SEGMENT", "type");
		    ParseByTagName(messageDom, "SERVICE", "name");
		    ParseByTagName(messageDom, "FILTER", "url");
		    ParserSegment(messageDom);
		  } catch (DOMException e) {
			  LogFactory.getLogger().severe("Cannot parse message :" + xml + "\n " + e.getLocalizedMessage());
		  }
	}

	private void ParserSegment(Document messageDom) {
		com.google.gwt.xml.client.NodeList list = messageDom.getElementsByTagName("SEGMENT");
		for (int i = 0; i < list.getLength(); i++) {
			com.google.gwt.xml.client.Node node = list.item(i);
			Element element = (Element)node;
			ParseService(element);
		}
	}

	private void ParseService(Element element) {		
		 ParseElementByTagName(element, "SERVICE", "name");
	}

	private void ParseElementByTagName(Element parent, String tag,
			String attr) {
		com.google.gwt.xml.client.NodeList list = parent.getElementsByTagName(tag);
		for (int i = 0; i < list.getLength(); i++) {
			com.google.gwt.xml.client.Node node = list.item(i);
			Element element = (Element)node;
			String name = element.getAttribute(attr);			
			System.out.println(tag +" " + attr +"="+name );
		}
	}

	private void ParseByTagName(Document messageDom, String tag, String attr) {
		com.google.gwt.xml.client.NodeList list = messageDom.getElementsByTagName(tag);
		for (int i = 0; i < list.getLength(); i++) {
			com.google.gwt.xml.client.Node node = list.item(i);
			Element element = (Element)node;
			String name = element.getAttribute(attr);			
			System.out.println(tag +" " + attr +"="+name );
		}
		
	}

}

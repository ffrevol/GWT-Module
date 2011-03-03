package com.ffrevol.gui.client.model;

import com.ffrevol.gui.tools.LogFactory;
import com.google.gwt.xml.client.DOMException;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;


public class ProvisioningParser implements ProvisioningParserI {
	
	private ProvisioningI provisioningModel;

	public ProvisioningParser() {
		LogFactory.getLogger().info("New  ProvisioningParser ");
	}

	@Override
	public void Parse(ProvisioningI _provisioningModel, String messageXml) {
		provisioningModel = _provisioningModel;
		LogFactory.getLogger().fine("Parse provisioning " + messageXml);
		//StackTrace();
		try {
		    // parse the XML document into a DOM
		    Document messageDom = XMLParser.parse(messageXml);
		    provisioningModel.setElement(messageDom);
		    ParseSegment(messageDom);		    
		  } catch (DOMException e) {
			  LogFactory.getLogger().severe("Cannot parse message :" + messageXml + "\n " + e.getLocalizedMessage());
		  }
	}

	private void StackTrace() {
		try 
		{
		throw new Exception("DEBUG");
		}
		catch (Exception e) {
			StackTraceElement[] st = e.getStackTrace();
			String stack = "";
			for (int i = 0; i < st.length; i++) {
			stack += st[i].toString()+ "\n";
			}
			LogFactory.getLogger().fine("StackTrace :"+ stack);
		}
		
	}

	private void ParseSegment(Document messageDom) {
		NodeList list = messageDom.getElementsByTagName(SegmentI.SEGMENT_TAG);
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			Element segment_element = (Element)node;			
			Segment segment = new Segment(segment_element);
			LogFactory.getLogger().fine(i + " : Created segment " + segment +  " for " + segment_element.toString());
			ParseService(segment);			
			provisioningModel.AddSegment(segment);
		}		 
	}

	private void ParseService(Segment segment) {
		NodeList list =
			segment.getElement().getElementsByTagName(ServiceI.SERVICE_TAG);
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			Element service_element = (Element)node;
			LogFactory.getLogger().fine("Parse element " + i + " : " + service_element.toString());
			Service service = new Service(service_element);
			ParseFilter(service);	
			segment.InsertService(service);
		}			
	}
	
	private void ParseFilter(Service service) {
		NodeList list = service.getElement().getElementsByTagName(FilterI.FILTER_TAG);		
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			Element filter_element = (Element)node;						
			Filter filter = new Filter(filter_element);
			service.InsertFilter(filter);
		}	
	}
}

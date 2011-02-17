package com.ffrevol.gui.server;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.ffrevol.gui.client.ProvisioningService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class ProvServlet extends RemoteServiceServlet implements ProvisioningService
{

	/**
	 * 
	 */	
	private static final String DESTINATION_FILE_PATH = "./provisioning.xml";

	@Override
	public String getProvisioning() throws IllegalArgumentException 
	{
		StringBuffer out = new StringBuffer();
		FileReader prov;
		try
		{
			prov = new FileReader(DESTINATION_FILE_PATH);
			char[] cbuf = new char[128];		
			while(prov.read(cbuf) > 0)
			{	 
				out.append(cbuf);
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found : " + 
						this.getServletContext().getRealPath(DESTINATION_FILE_PATH)); 
			e.printStackTrace();
			throw new IllegalArgumentException(e.getLocalizedMessage());
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
			throw new IllegalArgumentException(e.getLocalizedMessage());			
		}
		
		return out.toString();
	}

	@Override
	public String saveProvisioning(String data) throws IllegalArgumentException 
	{
		//data = escapeHtml(data);
		FileWriter writer;
		try
		{
			writer = new FileWriter(DESTINATION_FILE_PATH);
			writer.write(data);		
			writer.close();			
			return "";
		}
		catch (IOException e)
		{		
			e.printStackTrace();
			throw new IllegalArgumentException(e.getLocalizedMessage());
		}		

	}
	
	private String escapeHtml(String html) {
	    if (html == null) {
	      return null;
	    }
	    return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(
	        ">", "&gt;");
	  }

}

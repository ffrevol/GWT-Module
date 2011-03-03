package com.ffrevol.gui.client.model;

import java.util.List;

import com.ffrevol.gui.tools.LogFactory;
import com.google.gwt.junit.client.GWTTestCase;

public class ProvisioningParserGwtTest extends GWTTestCase {
	
	private static final String HTTP_WWW_VOLUBILL_COM = "http://www.volubill.com";
	String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	private ProvisioningParserI parser;
	private ProvisioningI provisioning;
	private String singleProv;
	private String emptyProv;
	private String multiProv;
	private String multiSvcProv;
	private int expected = 0;
	
	@Override
	public String getModuleName() {
		return "com.ffrevol.gui.provisioning_moduleJUnit";
	}

	
	public void gwtSetUp () {
		singleProv = xmlHeader + "<PROVISIONING><SEGMENT type=\"http\"><SERVICE id=\"1\" name=\"name\"><FILTER url=\"url\"/></SERVICE></SEGMENT></PROVISIONING>";
		emptyProv = xmlHeader + "<PROVISIONING><SEGMENT type=\"http\"></SEGMENT></PROVISIONING>";
		multiProv = xmlHeader + "<PROVISIONING><SEGMENT type=\"http\">"+ 
			"<SERVICE id=\"1\" name=\"name\"><FILTER url=\"url\"/></SERVICE>"+ 
			"<SERVICE id=\"2\" name=\"name2\"><FILTER url=\"url1\"/></SERVICE>"+
			"</SEGMENT>" +
				"				<SEGMENT type=\"vpf34\"><SERVICE id=\"1\" name=\"name\"><FILTER url=\"url\"/></SERVICE></SEGMENT>" +
				"				<SEGMENT type=\"wap\"><SERVICE id=\"1\" name=\"name\"><FILTER url=\"url\"/></SERVICE></SEGMENT>" +
				"</PROVISIONING>";
		multiSvcProv = xmlHeader + "<PROVISIONING><SEGMENT type=\"http\">"+ 
		"<SERVICE id=\"id1\" name=\"name1\"><FILTER url=\"url1\"/></SERVICE>"+ 
		"<SERVICE id=\"id2\" name=\"name2\"><FILTER url=\"url2\"/></SERVICE>"+
		"<SERVICE id=\"id3\" name=\"name3\"><FILTER url=\"url3\"/></SERVICE>"+
		"</SEGMENT>" +
			"				<SEGMENT type=\"vpf34\"><SERVICE id=\"1\" name=\"name\"><FILTER url=\"url\"/></SERVICE></SEGMENT>" +
			"				<SEGMENT type=\"wap\"><SERVICE id=\"1\" name=\"name\"><FILTER url=\"url\"/></SERVICE></SEGMENT>" +
			"</PROVISIONING>"; 
		parser = new ProvisioningParser();		
    }
	
	private void init(String prov)
	{
		provisioning = new ProvisioningModel();
		parser.Parse(provisioning, prov);
	}

	
	public void testParseXML()
	{		
		init(singleProv);		
		LogFactory.getLogger().severe("testParseXML");
		assertEquals(singleProv, provisioning.XMLStringValue());
	}
		
	public void testParseMultiXML()
	{		
		init(multiSvcProv);		
		assertOnMatchCount(provisioning, 1, "name1" );
		assertOnMatchCount(provisioning, 1, "name2" );
		assertOnMatchCount(provisioning, 1, "name3" );
		assertOnMatchCount(provisioning, 1, "id1" );
		assertOnMatchCount(provisioning, 1, "id2" );
		assertOnMatchCount(provisioning, 1, "id3" );
		
		
	}
	
	public void testGetSegmentName()
	{
		init(singleProv);
		onSegmentDo(provisioning,new SegmentActionI() {
			
			@Override
			public void Do(SegmentI sgt) {			
				String name = sgt.Name();
				assertEquals("http", name);
			}
		});
	}
	public void testGetServiceName()
	{
		init(singleProv);
		onServiceDo(provisioning, new ServiceActionI() {

			@Override
			public void Do(ServiceI svc) {
				String name = svc.Name();
				assertEquals("name", name);
			}			
		});
		
	}
	
	public void testEmptyAddService()
	{
		testAddService(emptyProv);
	}
	public void testSingleAddService()
	{
		testAddService(singleProv);
		
	}
	public void testMultiAddService()
	{
		testAddService(multiProv);
	}
	
	public void testEmptyAddFilter()
	{
		testAddFilter(emptyProv);
	}
	public void testSingleAddFilter()
	{
		testAddFilter(singleProv);
	}
	public void testMultiAddFilter()
	{
		testAddFilter(multiProv);
	}
	
	public void testSingleRemoveService()
	{
		testRemoveService(singleProv);
	}
	
	public void testMultiRemoveService()
	{
		testRemoveService(multiProv);
	}
	
	public void testSingleRemoveFilter()
	{
		testRemoveFilter(singleProv);
	}
	public void testMultiRemoveFilter()
	{
		testRemoveFilter(multiProv);
	}
	
	public void testEditServiceAttribute()
	{
		init(singleProv);
		final String custo = "###";
		final String name = "newname";
		expected = 0;
		onServiceDo(provisioning, new ServiceActionI() {

			@Override
			public void Do(ServiceI svc) {
				svc.Name(name);
				String ori = svc.Name();
				svc.Name(ori + custo);
				expected++;
			}			
		});
		assertOnMatchCount(provisioning, expected, name+custo);
	}

	public void testSetServiceAttributes()
	{
		init(singleProv);
		final String testId = "idTest";
		final String testName = "nameTest";
		expected = 0;
		onServiceDo(provisioning, new ServiceActionI() {
			@Override
			public void Do(ServiceI svc) {
				svc.Id(testId);
				svc.Name(testName);
				expected++;
			}
			
		});		
		assertOnMatchCount(provisioning, expected, "id=\"" + testId);		
		assertOnMatchCount(provisioning, expected, "name=\"" + testName);		
	}
	
	public void testSetFilter()
	{
		testSetFilterAttibutes(emptyProv);
		testSetFilterAttibutes(singleProv);
		testSetFilterAttibutes(multiProv);
	}
	
	private void testSetFilterAttibutes(String prov)
	{		
		init(prov);	
		final String testUrl = "urlTest";	
		expected = 0;
		onFilterDo(provisioning, new FilterActionI() {
			@Override
			public void Do(FilterI filt) {
				filt.URL(testUrl);
				expected++;
			}
		});
		assertOnMatchCount(provisioning, expected, "url=\"" + testUrl);
	}
	
	private void assertOnMatchCount(ProvisioningI source, int expected, String match)
	{
		String result = source.XMLStringValue();
		int count = Matcher.countMatches(result, match);
		assertEquals(expected, count);
	}
	
	private void testRemoveService(String prov)
	{
		init(prov);		
		expected = 0;
		onSegmentDo(provisioning, new SegmentActionI() {
			
			@Override
			public void Do(SegmentI sgt) {			
				List<ServiceI> svcList = sgt.Service();
				expected += svcList.size() - 1;
				ServiceI removed = sgt.RemoveService(svcList.get(0));
				assertNotNull(removed);
			}
		});
		assertOnMatchCount(provisioning, expected, "<SERVICE ");
	}
		
	private void testRemoveFilter(String prov)
	{
		init(prov);	
		expected = 0;
		onServiceDo(provisioning, new ServiceActionI() {
			
			@Override
			public void Do(ServiceI svc) {
				expected += svc.Filter().size() - 1;
				FilterI removed = svc.RemoveFilter(svc.Filter().get(0));
				assertNotNull(removed);
			}
		});
		assertOnMatchCount(provisioning, expected, "<FILTER ");		
	}
	
	
	
	private void onSegmentDo(ProvisioningI provisioning, SegmentActionI action)
	{
		List<SegmentI> list = provisioning.Segment();		
		for(SegmentI sgt : list)
		{	
		action.Do(sgt);
		}
	}
	private void onServiceDo(ProvisioningI provisioning, ServiceActionI action)
	{	
		List<SegmentI> list = provisioning.Segment();		
		for(SegmentI sgt : list)
		{	
			List<ServiceI> svcList = sgt.Service();
			for(ServiceI svc : svcList)
			{
				action.Do(svc);
			}
		}
	}
	private void onFilterDo(ProvisioningI provisioning, FilterActionI action)
	{	
		List<SegmentI> list = provisioning.Segment();		
		for(SegmentI sgt : list)
		{	
			List<ServiceI> svcList = sgt.Service();
			for(ServiceI svc : svcList)
			{	
				List<FilterI> filtList = svc.Filter();
				for(FilterI filt : filtList)
				{
					action.Do(filt);
				}
			}
		}
	}

	private void testAddService(String prov)
	{
		init(prov);
		expected = 0;
		onSegmentDo(provisioning, new SegmentActionI() {
			
			@Override
			public void Do(SegmentI sgt) {			
				sgt.AddService(sgt.NewService("namenew", "idnew"));
				expected++;
			}
		});		
		assertOnMatchCount(provisioning, expected, "id=\"idnew\"");		
		assertOnMatchCount(provisioning, expected, "name=\"namenew\"");		
	}
	
	private void testAddFilter(String prov)
	{
		init(prov);		
		expected = 0;
		onServiceDo(provisioning, new ServiceActionI() {
			
			@Override
			public void Do(ServiceI svc) {
				expected ++;				
				svc.AddFilter(svc.NewFilter(HTTP_WWW_VOLUBILL_COM));
			}
		});
		assertOnMatchCount(provisioning, expected, HTTP_WWW_VOLUBILL_COM);			
	}
	
	
	
}

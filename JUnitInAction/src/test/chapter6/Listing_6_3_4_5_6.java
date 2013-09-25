package test.chapter6;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.TestCase;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.ByteArrayISO8859Writer;
import org.junit.Test;

import test.required.WebClient;

public class Listing_6_3_4_5_6 extends TestCase{
	
	private Server server;
	
	@Override
	protected void setUp() throws Exception {
		setUpJetty();
	}
	
	private void setUpJetty() throws Exception{
		server = new Server(8080);
	}
	
	@Override
	protected void tearDown() throws Exception {
		server.stop();
	}
	
	@Test
	public void testGetContent() throws Exception{
		server.setHandler(new TestGetContentOKHandler());
		server.start();
		
		WebClient webClient = new WebClient();
		String content = webClient.getContent(new URL("http://localhost:8080/testContentGetOK"));
		assertTrue(content.equals("OK"));
	}
	
	@Test
	public void testGetContentNotFound() throws Exception{
		//keeping the resource handler as the resource requested will not be found it will throw IOException and null should be returned
		server.setHandler(new ResourceHandler());
		server.start();
		
		WebClient webClient = new WebClient();
		String content = webClient.getContent(new URL("http://localhost:8080/test"));
		assertEquals(null,content);
	}
	
	private class TestGetContentOKHandler extends AbstractHandler{

		@Override
		public void handle(String arg0, Request arg1, HttpServletRequest arg2,HttpServletResponse arg3) throws IOException, ServletException {
			OutputStream outputStream = arg3.getOutputStream();
			ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
			writer.write("OK");
			writer.flush();
			writer.writeTo(outputStream);
			outputStream.flush();
			arg1.setHandled(true);
			arg3.setStatus(HttpServletResponse.SC_OK);
		}
	}
}

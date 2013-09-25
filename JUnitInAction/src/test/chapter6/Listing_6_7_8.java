package test.chapter6;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

import junit.framework.TestCase;

import org.junit.Test;

import test.required.WebClient;

public class Listing_6_7_8 extends TestCase{

	@Override
	protected void setUp() throws Exception {
		URL.setURLStreamHandlerFactory(new StubHTTPURLStreamHandlerFactory());
	}
	
	@Test
	public void testGetContent() throws MalformedURLException{
		WebClient client = new WebClient();
		String content = client.getContent(new URL("http://localhost:8080/testContentGetOK"));
		assertEquals("OK", content);
	}
	
	private class StubHTTPURLStreamHandlerFactory implements URLStreamHandlerFactory{

		@Override
		public URLStreamHandler createURLStreamHandler(String protocol) {
			return new StubHTTPStreamHandler();
		}
	}
	
	private class StubHTTPStreamHandler extends URLStreamHandler{

		@Override
		protected URLConnection openConnection(URL u) throws IOException {
			return new StubHTTPConnection(u);
		}
	}
	
	private class StubHTTPConnection extends HttpURLConnection{
		private boolean isInput = true;
		
		protected StubHTTPConnection(URL u) {
			super(u);
		}

		@Override
		public void disconnect() {
			
		}

		@Override
		public boolean usingProxy() {
			return false;
		}

		@Override
		public void connect() throws IOException {
		}

		@Override
		public InputStream getInputStream() throws IOException {
			ByteArrayInputStream byteArray = new ByteArrayInputStream(new String("OK").getBytes());
			return byteArray;
		}
	}
}

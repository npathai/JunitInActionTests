package test.required;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import test.chapter7.Listing7_7;

public class TestableWebClient extends Listing7_7{

	private HttpURLConnection httpUrlConnection;
	
	public TestableWebClient(HttpURLConnection httpUrlConnection) {
		this.httpUrlConnection = httpUrlConnection;
	}
	
	@Override
	protected HttpURLConnection createHTTPURLConnection(URL url)throws IOException {
		return httpUrlConnection;
	}
}

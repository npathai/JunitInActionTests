package test.required;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPUrlConnectionFactory implements ConnectionFactory{

	private URL url;
	public HTTPUrlConnectionFactory(URL url) {
		this.url = url;
	}
	
	@Override
	public InputStream getData() throws IOException {
		HttpURLConnection connection  = (HttpURLConnection) url.openConnection();
		return connection.getInputStream();
	}
}

package test.required;

import java.io.IOException;
import java.io.InputStream;

public class MockConnectionFactory implements ConnectionFactory{

	private InputStream inputStream;
	
	public MockConnectionFactory(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	@Override
	public InputStream getData() throws IOException {
		return inputStream;
	}

}

package test.chapter7;

import junit.framework.TestCase;

import org.junit.Test;

import test.required.MockConnectionFactory;
import test.required.MockInputStream;

public class TestWebClientWithMockInputStream extends TestCase{

	@Test
	public void testWebClient(){
		MockInputStream mockInputStream = new MockInputStream();
		mockInputStream.setBuffer("OK");
		
		MockConnectionFactory mockConnectionFactory = new MockConnectionFactory(mockInputStream);
		
		//Listing7_9 webClient = new Listing7_9(); will make the test case fail
		
		Listing7_14 webClient = new Listing7_14(); //this will pass
		
		String result = webClient.getContent(mockConnectionFactory);
		
		assertEquals("OK", result);
		
		mockInputStream.verifyCloseCount();
	}
}

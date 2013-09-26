package test.chapter7;

import java.io.ByteArrayInputStream;

import junit.framework.TestCase;

import org.junit.Test;

import test.required.MockConnectionFactory;

public class Listing7_12 extends TestCase{

	@Test
	public void testWebClient(){
		MockConnectionFactory mockConnectionFactory = new MockConnectionFactory(
				new ByteArrayInputStream("OK".getBytes()));
		
		Listing7_9 webClient = new Listing7_9();
		
		String result = webClient.getContent(mockConnectionFactory);
		
		assertEquals("OK", result);
	}
}

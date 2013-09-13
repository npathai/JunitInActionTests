package test.chapter3;

import junit.framework.TestCase;
import test.required.DefaultController;
import test.required.ErrorResponse;
import test.required.Request;
import test.required.RequestHandler;
import test.required.Response;

public class Listing3_5_6_7_8_9_10_11_12_13 extends TestCase{

	private DefaultController controller;
	private Request request;
	private RequestHandler handler;
	
	//Method to bootstrap the test case
	@Override
	protected void setUp() throws Exception {
		controller = new DefaultController();
		request = new TestRequest();
		handler = new TestHandler();
		controller.addHandler(request, handler);
	}
	
	public void testAddHandler(){
		//assert the result to see if handler is not null
		assertNotNull(controller.getHandler(request));
		
		//assert to see if the same handler instance is returned back
		assertSame(handler, controller.getHandler(request));
	}
	
	public void testProcessRequest(){
		//apply stimulus
		Response response = controller.processRequest(request);
		
		//assert to see if response is not null
		assertNotNull("Response object MUST not be null", response);
		
		//assert to see if the controller passed the process control to valid controller
		assertEquals(TestResponse.class, response.getClass());
	}
	
	public void testProcessRequestWithEnhancedTestResponse(){
		//apply stimulus
		Response response = controller.processRequest(request);
		
		//assert that both the instances are of test response type i.e. our dummy type
		assertEquals(new TestResponse(), response);
	}
	
	public void testProcessRequestAnswersErrorResponse(){
		//test fixture
		TestRequest request = new TestRequest("testError");
		TestExceptionHandler handler = new TestExceptionHandler();
		controller.addHandler(request, handler);
		
		//apply stimulus
		Response response = controller.processRequest(request);
		
		//assert
		assertNotNull("Response MUST never be null", response);
		
		assertEquals(ErrorResponse.class, response.getClass());
	}
	
	public void testGetHandlerNotDefined(){
		try{
			controller.getHandler(new TestRequest("Unregistered"));
			fail("An exception should be raised if the requested handler is not registered");
		}catch (RuntimeException e) {
			assertTrue(true);
		}
	}
	
	public void testAddHandlerDuplicateEntry(){
		try{
			controller.addHandler(new TestRequest(), new TestHandler());
			fail("An exception should be raised if default TestResult is already registered.");
		}catch (RuntimeException e) {
			assertTrue(true);
		}
	}
	
	
	/*
	 * Private dummy classes for testing only the controller and not other objects
	 */
	private class TestRequest implements Request{
		private static final String DEFAULT_NAME = "Test";
		
		private String name;
		
		public TestRequest(String name){
			this.name = name;
		}
		
		public TestRequest() {
			this(DEFAULT_NAME);
		}
		
		@Override
		public String getName() {
			return name;
		}
	}
	
	private class TestHandler implements RequestHandler{

		@Override
		public Response process(Request request) throws Exception {
			return new TestResponse();
		}
	}
	
	private class TestResponse implements Response{
		private static final String NAME = "Test";
		
		public String getName(){
			return NAME;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof TestResponse))
				return false;
			return getName().equals(((TestResponse)obj).getName());
		}
		
		@Override
		public int hashCode() {
			return NAME.hashCode();
		}
	}
	
	private class TestExceptionHandler implements RequestHandler{

		@Override
		public Response process(Request request) throws Exception {
			throw new Exception("Error in processing request");
		}
		
	}
}

package test.chapter3;

import junit.framework.TestCase;
import test.required.DefaultController;

public class Listing3_4 extends TestCase{

	private DefaultController controller;
	
	//Method to bootstrap the test case
	@Override
	protected void setUp() throws Exception {
		controller = new DefaultController();
	}
	
	//just a dummy test to see that the controller has been set up properly
	public void testMethod(){
		assertNotNull(controller);
	}
}

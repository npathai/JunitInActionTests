package test.chapter2;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestDefaultController extends TestCase{

	public TestDefaultController(String name) {
		super(name);
	}
	
	public void testDummy1(){
		assertEquals(true, true);
	}
	
	//This is always meant to break the suite so lets skip it from the test suite
	public void testDummy2(){
		assertEquals(true, false);
	}
	
	//So building your own test suite allows you to skip broken tests
	/*In most cases you don't need a suite method as JUnit framework takes care of that automatically, 
	 * but you need it if you need better control.
	 */
	
	public static Test suite(){
		TestSuite testSuite = new TestSuite();
		testSuite.addTest(new TestDefaultController("testDummy1"));
		//This test case is broken so lets skip it
		//testSuite.addTest(new TestDefaultController("testDummy2"));
		return testSuite;
	}
}

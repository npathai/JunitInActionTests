package test.chapter2;

import test.chapter1.Listing1_4;
import junit.framework.Test;
import junit.framework.TestSuite;


public class Listing2_3{

		public static Test suite(){
			TestSuite testSuite = new TestSuite("All tests from part 1");
			testSuite.addTestSuite(Listing1_4.class);
			
			//uses the suite method to return only the tests that need to be executed
			testSuite.addTest(TestDefaultController.suite());
			
			return testSuite;
		}
}

package test.chapter1;

import test.chapter1.required.Calculator;
import junit.framework.TestCase;

//Any class that requires to use the JUnit Testing framework needs to extend TestCase Class
public class Listing1_4 extends TestCase{

	//Any test that you want to execute should have a testXXX() format for JUnit framework to pick it up as test
	public void testAdd(){
		Calculator calculator = new Calculator();
		double sum = calculator.add(10,20);
		
		//JUnit provides extensive assert framework for testing the output
		assertEquals(30, sum,0);
	}
}

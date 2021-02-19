package com.shahzeb.StringAdder;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * @throws Exception 
     * Rigourous Test :-)
     * @throws  
     */
    public void testApp() throws Exception
    {
    	App obj = new App();
    	assertEquals(0, obj.Add(""));
    	assertEquals(1, obj.Add("1"));
    	assertEquals(3, obj.Add("1,2"));
    	assertEquals(3, obj.Add("1\n2"));
    	assertEquals(10, obj.Add("1\n2,3,4"));
    	assertEquals(10, obj.Add("//;\n1\n2;3;4"));
    	//assertEquals(10, obj.Add("//;\n1\n2;3;-4"));
    	//assertEquals(10, obj.Add("//;\n-1\n2;-3;-4"));
    	assertEquals(8, obj.Add("//;\n1\n1001;3;4"));
    	assertEquals(8, obj.Add("//;\n1\n2001;3;4"));
    	
    }
}

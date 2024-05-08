package com.markwatson.openai;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class OpenAICompletionsTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public OpenAICompletionsTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( OpenAICompletionsTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws Exception 
     */
    public void testCompletion() throws Exception
    {
        String r = OpenAICompletions.getCompletion("Translate the following English text to French: 'Hello, how are you?'");
        System.out.println("completion: " + r);
        assertTrue( true );
    }
    public void testSummarization() throws Exception {
        // read template file and test text summarization
        assertTrue( "not implemented" , true);
    }
    public void testExtraction() throws Exception {
        // read template file and test extracting information
        // from CSV files and conveting to JSON
        assertTrue( "not implemented" , true);
    }
}

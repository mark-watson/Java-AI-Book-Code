package com.markwatson.openai;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class OpenAICompletionsExampleTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public OpenAICompletionsExampleTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( OpenAICompletionsExampleTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws Exception 
     */
    public void testCompletion() throws Exception
    {
        String r = OpenAICompletionsExample.getCompletion("Translate the following English text to French: 'Hello, how are you?'");
        System.out.println("completion: " + r);
        assertTrue( true );
    }
    public void testSummarization() throws Exception {
        // read template file and test text summarization
        assertTrue( false );
    }
    public void testExtraction() throws Exception {
        // read template file and test extracting information
        // from CSV files and conveting to JSON
        assertTrue( false );
    }
}

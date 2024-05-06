package com.markwatson.openai;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class OllamaLlmClientTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public OllamaLlmClientTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( OllamaLlmClientTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws Exception 
     */
    public void testCompletion() throws Exception
    {
        String r =
        OllamaLlmClient.getCompletion("Translate the following English text to French: 'Hello, how are you?'", "mistral");
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

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

    public void testTwoShotTemplate() throws Exception {
        String input_text = "Mark Johnson enjoys living in Berkeley California at 102 Dunston Street and use mjess@foobar.com for contacting him.";
        String prompt0 = OpenAICompletions.readFileToString("../prompts/two-shot-2-var.txt");
        System.out.println("prompt0: " + prompt0);
        String prompt = OpenAICompletions.promptVar(prompt0, "{input_text}", input_text);
        System.out.println("prompt: " + prompt);
        String r =
        OpenAICompletions.getCompletion(prompt);
        System.out.println("two shot extraction completion: " + r);
        assertTrue( true );
    }

    public void testSummarization() throws Exception {
        String input_text = "Jupiter is the fifth planet from the Sun and the largest in the Solar System. It is a gas giant with a mass one-thousandth that of the Sun, but two-and-a-half times that of all the other planets in the Solar System combined. Jupiter is one of the brightest objects visible to the naked eye in the night sky, and has been known to ancient civilizations since before recorded history. It is named after the Roman god Jupiter.[19] When viewed from Earth, Jupiter can be bright enough for its reflected light to cast visible shadows,[ and is on average the third-brightest natural object in the night sky after the Moon and Venus.";
        String prompt0 = OpenAICompletions.readFileToString("../prompts/summarization_prompt.txt");
        System.out.println("prompt0: " + prompt0);
        String prompt = OpenAICompletions.promptVar(prompt0, "{input_text}", input_text);
        System.out.println("prompt: " + prompt);
        String r =
        OpenAICompletions.getCompletion(prompt);
        System.out.println("summarization completion: " + r);
        assertTrue( true );
    }
}

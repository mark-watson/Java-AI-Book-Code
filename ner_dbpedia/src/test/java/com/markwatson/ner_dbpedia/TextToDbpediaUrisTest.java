package com.markwatson.ner_dbpedia;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TextToDbpediaUrisTest extends TestCase {
  /**
   * Create the test case
   *
   * @param testName name of the test case
   */
  public TextToDbpediaUrisTest(String testName)
  {
    super( testName );
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite()
  {
    return new TestSuite( TextToDbpediaUrisTest.class );
  }

  /**
   * Test that is just for side effect printouts:
   */
  public void test1() throws Exception {
    String s = "PTL Satellite Network covered President Bill Clinton going to Guatemala and visiting the Coca Cola Company.";
    TextToDbpediaUris test = new TextToDbpediaUris(s);
    System.out.println(test);
    assert(true);
  }

}

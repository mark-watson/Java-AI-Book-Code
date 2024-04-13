package com.markwatson.info_spiders;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for NLP.
 */
public class WebClientTest extends TestCase {

  public WebClientTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    return new TestSuite(WebClientTest.class);
  }

  public void testFetchAndDisplay() throws Exception {
    assertTrue(true);
    WebSpider client = new WebSpider("https://markwatson.com", 10);
    //WebSpider client = new WebSpider("http://pbs.org", 10);
    //WebSpider client = new WebSpider("http://kbsportal.com", 10);
    System.out.println("Found URIs: " + client.url_content_lists);
  }
}

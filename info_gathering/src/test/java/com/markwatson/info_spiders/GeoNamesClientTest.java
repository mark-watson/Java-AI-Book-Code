package com.markwatson.info_spiders;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for NLP.
 */
public class GeoNamesClientTest extends TestCase {

  public GeoNamesClientTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    return new TestSuite(GeoNamesClientTest.class);
  }

  public void testFetchAndDisplay() throws Exception {
    assertTrue(true);
    GeoNamesClient client = new GeoNamesClient();
    System.out.println(client.getCityData("Paris"));        pause();
    System.out.println(client.getCountryData("Canada")); pause();
    System.out.println(client.getStateData("California")); pause();
    System.out.println(client.getRiverData("Amazon"));     pause();
    System.out.println(client.getMountainData("Whitney"));
  }
  private static void pause() {
    try { Thread.sleep(2000);
    } catch (Exception ignore) { }
  }
}


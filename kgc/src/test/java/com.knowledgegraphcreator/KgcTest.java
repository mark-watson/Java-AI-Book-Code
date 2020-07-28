package com.knowledgegraphcreator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class KgcTest extends TestCase {

  public KgcTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    return new TestSuite(KgcTest.class);
  }

  public void testKGC() throws Exception {
    assertTrue(true);
    KGC client = new KGC("test_data/", "output_with_duplicates.rdf");
  }
  private static void pause() {
    try { Thread.sleep(2000);
    } catch (Exception ignore) { }
  }
}

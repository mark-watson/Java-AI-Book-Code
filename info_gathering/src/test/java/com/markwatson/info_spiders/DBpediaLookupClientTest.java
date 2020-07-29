package com.markwatson.info_spiders;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;
import java.util.Map;

/**
 * Unit test for NLP.
 */
public class DBpediaLookupClientTest extends TestCase {

  public DBpediaLookupClientTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    return new TestSuite(DBpediaLookupClientTest.class);
  }

  public void testFetchAndDisplay() throws Exception {
    DBpediaLookupClient client = new DBpediaLookupClient("London UK");
    List<Map<String, String>> results = client.variableBindings();
    System.out.println("# query results: " + results.size());
    for (Map<String, String> map : results) {
      for (Map.Entry<String, String> entry : map.entrySet()) {
        System.out.println(entry.getKey() + " - " + entry.getValue());
      }
    }
  }
}

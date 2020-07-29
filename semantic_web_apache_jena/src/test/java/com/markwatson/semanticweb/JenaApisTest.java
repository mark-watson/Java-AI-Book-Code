package com.markwatson.semanticweb;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class JenaApisTest extends TestCase {
  /**
   * Create the test case
   *
   * @param testName name of the test case
   */
  public JenaApisTest(String testName)
  {
    super( testName );
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite()
  {
    return new TestSuite( JenaApisTest.class );
  }

  /**
   * Test that is just for side effect printouts:
   */
  public void test1() throws Exception {
    JenaApis jenaApis = new JenaApis();
    // test remote SPARQL queries against DBPedia SPARQL endpoint
    QueryResult qrRemote = jenaApis.queryRemote(
        "https://dbpedia.org/sparql",
        "select ?p where { <http://dbpedia.org/resource/Bill_Gates> ?p <http://dbpedia.org/resource/Microsoft> . } limit 10");
//        "select distinct ?s { ?s ?p <http://dbpedia.org/resource/Parks> } LIMIT 10");
    System.out.println("qrRemote:" + qrRemote);
    System.out.println("Repeat query to test caching:");
    qrRemote = jenaApis.queryRemote(
        "https://dbpedia.org/sparql",
        "select distinct ?s { ?s ?p <http://dbpedia.org/resource/Parks> } LIMIT 10");
    System.out.println("qrRemote (hopefully from cache):" + qrRemote);

    jenaApis.loadRdfFile("data/rdfs_business.nt");
    jenaApis.loadRdfFile("data/sample_news.nt");
    jenaApis.loadRdfFile("data/sample_news.n3");

    QueryResult qr = jenaApis.query(
        "select ?s ?o where { ?s <http://knowledgebooks.com/title> ?o } limit 15");
    System.out.println("qr:" + qr);

    jenaApis.saveModelToTurtleFormat("model_save.nt");
    jenaApis.saveModelToN3Format("model_save.n3");
  }

  /**
   * Test that is just for side effect printouts:
   */
  public void testOwlReasoning() throws Exception {
    JenaApis jenaApis = new JenaApis();
    jenaApis.loadRdfFile("data/news.n3");

    QueryResult qr = jenaApis.query(
        "prefix kb:  <http://knowledgebooks.com/ontology#> \n" +
        "select ?s ?o where { ?s kb:containsCity ?o } ");
    System.out.println("qr:" + qr);

    qr = jenaApis.query(
        "prefix kb:  <http://knowledgebooks.com/ontology#> \n" +
            "select ?s ?o where { ?s kb:containsPlace ?o }");
    System.out.println("qr:" + qr);

    qr = jenaApis.query(   // count for each place name
        "prefix kb:  <http://knowledgebooks.com/ontology#> \n" +
            "select ?o (count(*) as ?count) where { ?s kb:containsPlace ?o } " +
            "group by ?o");
    System.out.println("qr:" + qr);
  }

}
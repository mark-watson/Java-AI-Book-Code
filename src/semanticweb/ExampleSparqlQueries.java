package semanticweb;

import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.repository.RepositoryException;
import org.openrdf.rio.RDFParseException;

import java.io.IOException;
import java.util.List;


/**
 *
 * <p/>
 * Copyright 2002-2012 by Mark Watson. All rights reserved.
 * <p/>
 * This software is not public domain. It can be legally
 * used under either of the following licenses:
 * <p/>
 * 1. LGPL
 * 2. Apache 2
 */
public class ExampleSparqlQueries implements ISparqlProcessResults {

      public static void main (String [] args) throws RepositoryException, IOException, RDFParseException, MalformedQueryException, QueryEvaluationException {
      new ExampleSparqlQueries();
  }
  
  public ExampleSparqlQueries() throws RepositoryException, IOException, RDFParseException, MalformedQueryException, QueryEvaluationException {
      TripleStoreSesameManager ts = new TripleStoreSesameManager();
      ts.loadRDF("test_data/news.n3");
      System.out.println("\n\nSample querying for subjects (news article URLs) and objects (names of matching countries) with predicate equal to containsCountry:\n");
      String sparql_query = "SELECT ?subject ?object WHERE { ?subject <http://knowledgebooks.com/ontology#containsCountry> ?object . }";
      // using namespaces also works:
      //String sparql_query = "PREFIX kb:  <http://knowledgebooks.com/ontology#> SELECT ?subject ?object WHERE { ?subject kb:containsCountry ?object . }";
      ts.doSparqlQuery(sparql_query, this);
      
      System.out.println("\n\nSample using inferencing: query on containsPlace using definition in rdfs.nt:\n");
      sparql_query = "SELECT ?subject ?object WHERE { ?subject <http://knowledgebooks.com/ontology#containsPlace> ?object . }";
      ts.doSparqlQuery(sparql_query, this);
      
      System.out.println("\n\nSample using match against a string literal\n");
      sparql_query = "PREFIX kb: <http://knowledgebooks.com/ontology#> SELECT ?subject ?object WHERE { ?subject kb:containsState \"Maryland\" . }";
      ts.doSparqlQuery(sparql_query, this); // <http:://knowledgebooks.com/ontology/#

      System.out.println("\n\nSample using match against a string regular expression match\n");
      sparql_query = "PREFIX kb: <http://knowledgebooks.com/ontology#> SELECT ?subject ?object WHERE { ?subject kb:containsOrganization ?object FILTER regex(?object, \"University\") . }";
      ts.doSparqlQuery(sparql_query, this); // <http:://knowledgebooks.com/ontology/#

      System.out.println("\n\nSample using match against a string regular expression match, returning all triples with same subject:\n");
      sparql_query = "PREFIX kb: <http://knowledgebooks.com/ontology#> SELECT DISTINCT ?subject ?a_predicate ?an_object WHERE { ?subject kb:containsOrganization ?object FILTER regex(?object, \"University\") . ?subject ?a_predicate ?an_object . } ORDER BY ?a_predicate  ?an_object LIMIT 12 OFFSET 5";
      ts.doSparqlQuery(sparql_query, this); // <http:://knowledgebooks.com/ontology/#
      

      
  }

    public void processResult(List<String> data) {
       System.out.print("next result: "); 
       for (String s : data) System.out.print("|"+s+"|" + "\t  ");
       System.out.println(" . ");
    }
}


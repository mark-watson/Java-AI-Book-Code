package semanticweb;

import java.io.IOException;
import java.util.List;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.repository.RepositoryException;
import org.openrdf.rio.RDFParseException;


/**
 *
 * <p/>
 * Copyright 2002-2008 by Mark Watson. All rights reserved.
 * <p/>
 * This software is not public domain. It can be legally
 * used under either of the following licenses:
 * <p/>
 * 1. LGPL
 * 2. Apache 2
 */
public class SparqlQueries implements ISparqlProcessResults {
  public static void main (String [] args) throws RepositoryException, IOException, RDFParseException, MalformedQueryException, QueryEvaluationException {
      new SparqlQueries();
  }
  
  public SparqlQueries() throws RepositoryException, IOException, RDFParseException, MalformedQueryException, QueryEvaluationException {
      TripleStoreSesameManager ts = new TripleStoreSesameManager();
      ts.loadRDF("rdf_files/knowledgebooks_namespace.n3");
      ts.loadRDF("rdf_files/rdfs.nt");
      ts.loadRDF("rdf_files/news.nt");
      System.out.println("\n\nSample querying for subjects (news article URLs) and objects (names of matching countires) with predicate equal to containsCountry:\n");
      String sparql_query = "SELECT ?subject ?object WHERE { ?subject <http:://knowledgebooks.com/ontology/#containsCountry> ?object . }";
      //String sparql_query = "PREFIX kb:  <http://knowlegebooks.com/ontology#> SELECT ?subject ?object WHERE { ?subject kb:containsCountry ?object . }";
      //String sparql_query = "SELECT ?subject ?object ?predicate { ?subject ?object ?predicate . }";
      ts.doSparqlQuery(sparql_query, this);
      
      System.out.println("\n\nSample using inferencing: query on containsPlace using definition in rdfs.nt:\n");
      sparql_query = "SELECT ?subject ?object WHERE { ?subject <http:://knowledgebooks.com/ontology/#containsPlace> ?object . }";
      ts.doSparqlQuery(sparql_query, this);
      
      System.out.println("\n\nSample using kb: namespace defined in knowledgebooks.nt:\n");
      sparql_query = "PREFIX kb:  <http://knowlegebooks.com/ontology/#> SELECT ?subject ?object WHERE { ?subject kb:containsState ?object . }";
      ts.doSparqlQuery(sparql_query, this); // <http:://knowledgebooks.com/ontology/#
      
  }

    public void processResult(List<String> data) {
       System.out.print("next result: "); 
       for (String s : data) System.out.print("|"+s+"|" + "\t  ");
       System.out.println(" . ");
    }
}

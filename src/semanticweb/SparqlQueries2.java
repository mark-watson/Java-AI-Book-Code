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
public class SparqlQueries2 implements ISparqlProcessResults {
  public static void main (String [] args) throws RepositoryException, IOException, RDFParseException, MalformedQueryException, QueryEvaluationException {
      new SparqlQueries2();
  }
  
  public SparqlQueries2() throws RepositoryException, IOException, RDFParseException, MalformedQueryException, QueryEvaluationException {
      TripleStoreSesameManager ts = new TripleStoreSesameManager();
      ts.loadRDF("rdf_files/news.nt");
      String sparql_query = "SELECT ?subject ?object WHERE { ?subject <http:://knowledgebooks.com/ontology#containsCountry> ?object . }";
      ts.doSparqlQuery(sparql_query, this);
  }

    public void processResult(List<String> data) {
       System.out.print("next result: "); 
       for (String s : data) System.out.print("|"+s+"|" + "\t  ");
       System.out.println(" . ");
    }
}

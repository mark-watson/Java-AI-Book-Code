package com.knowledgegraphnavigator;

import com.markwatson.semanticweb.QueryResult;
import com.markwatson.semanticweb.JenaApis;
import static com.knowledgegraphnavigator.Log.sparql;
import static com.knowledgegraphnavigator.Log.out;

import java.sql.SQLException;

public class Sparql {
  //static private String endpoint = "https://query.wikidata.org/bigdata/namespace/wdq/sparql";
  static private String endpoint = "https://dbpedia.org/sparql";
  public Sparql() {
    this.jenaApis = new JenaApis();
  }

  public QueryResult query(String sparqlQuery) throws SQLException, ClassNotFoundException {
    //out(sparqlQuery); // debug for now...
    sparql.append(sparqlQuery);
    sparql.append(("\n\n"));
    return jenaApis.queryRemote(endpoint, sparqlQuery);
  }
  private JenaApis jenaApis;

  public static void main(String[] args) throws Exception {
    Sparql sp = new Sparql();
    QueryResult qr = sp.query("select ?s ?p ?o where { ?s ?p ?o } limit 5");
    out(qr.toString());
  }
}

package com.markwatson.semanticweb;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JenaApis {

  public JenaApis() {
    //model = ModelFactory.createDefaultModel(); // use if OWL reasoning not required
    model = ModelFactory.createOntologyModel(); // use OWL reasoner
  }

  public Model model() {
    return model;
  }

  public void loadRdfFile(String fpath) {
    model.read(fpath);
  }

  public void saveModelToTurtleFormat(String outputPath) throws IOException {
    FileOutputStream fos = new FileOutputStream(outputPath);
    RDFDataMgr.write(fos, model, RDFFormat.TRIG_PRETTY);
    fos.close();
  }
  public void saveModelToN3Format(String outputPath) throws IOException {
    FileOutputStream fos = new FileOutputStream(outputPath);
    RDFDataMgr.write(fos, model, RDFFormat.NTRIPLES);
    fos.close();
  }

  public QueryResult query(String sparqlQuery) {
    Query query = QueryFactory.create(sparqlQuery);
    QueryExecution qexec = QueryExecutionFactory.create(query, model);
    ResultSet results = qexec.execSelect();
    QueryResult qr = new QueryResult(results.getResultVars());
    for (; results.hasNext(); ) {
      QuerySolution solution = results.nextSolution();
      List<String> newResultRow = new ArrayList();
      for (String var : qr.variableList) {
        newResultRow.add(solution.get(var).toString());
      }
      qr.rows.add(newResultRow);
    }
    return qr;
  }

  public QueryResult queryRemote(String service, String sparqlQuery) throws SQLException, ClassNotFoundException {
    if (cache == null) cache = new Cache();
    byte [] b = cache.fetchResultFromCache(sparqlQuery);
    if (b != null) {
      //System.out.println("Found query in cache.");
      QueryResult l = SerializationUtils.deserialize(b);
      return l;
    }
    Query query = QueryFactory.create(sparqlQuery);
    QueryExecution qexec = QueryExecutionFactory.sparqlService(service, sparqlQuery);
    ResultSet results = qexec.execSelect();
    QueryResult qr = new QueryResult(results.getResultVars());
    for (; results.hasNext(); ) {
      QuerySolution solution = results.nextSolution();
      List<String> newResultRow = new ArrayList();
      for (String var : qr.variableList) {
        newResultRow.add(solution.get(var).toString());
      }
      qr.rows.add(newResultRow);
    }
    byte [] b3 = SerializationUtils.serialize(qr);
    cache.saveQueryResultInCache(sparqlQuery, b3);
    return qr;
  }

  private Cache cache = null;
  private Model model;

  public static void main(String[] args) {
    /*
    Execute using, for example:
         mvn exec:java -Dexec.mainClass="com.markwatson.semanticweb.JenaApis" \
             -Dexec.args="data/news.n3"
     */
    JenaApis ja = new JenaApis();
    System.out.println(args.length);
    if (args.length == 0) {
      // no RDF input file names on command line so use a default file:
      ja.loadRdfFile("data/news.n3");
    } else {
      for (String fpath : args) {
        ja.loadRdfFile(fpath);
      }
    }
    System.out.println("Multi-line queries are OK but don't use blank lines.");
    System.out.println("Enter a blank line to process query.");
    while (true) {
      System.out.println("Enter a SPARQL query:");
      Scanner sc = new Scanner(System.in);
      StringBuilder sb = new StringBuilder();
      while (sc.hasNextLine()) {  //until no other inputs to proceed
        String s = sc.nextLine();
        if (s.equals("quit") || s.equals("QUIT") || s.equals("exit") || s.equals("EXIT"))
          System.exit(0);
        if (s.length() < 1) break;
        sb.append(s);
        sb.append("\n");
      }
      QueryResult qr = ja.query(sb.toString());
      System.out.println(qr);
    }
  }
}
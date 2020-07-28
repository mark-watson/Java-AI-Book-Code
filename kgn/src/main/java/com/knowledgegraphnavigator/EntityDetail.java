package com.knowledgegraphnavigator;

import com.markwatson.semanticweb.QueryResult;

import java.sql.SQLException; // Cache layer in JenaApis library throws this

public class EntityDetail {

  static public QueryResult genericResults(Sparql endpoint, String entityUri)
      throws SQLException, ClassNotFoundException {
    String query =
        String.format(
            "select distinct ?p ?o where { %s ?p ?o . FILTER (!regex(str(?p), 'wiki', 'i')) " +
                " . FILTER (!regex(str(?p), 'wiki', 'i')) } limit 10",
            entityUri);
    return endpoint.query(query);
  }

  static public String genericAsString(Sparql endpoint, String entityUri)
      throws SQLException, ClassNotFoundException {
    QueryResult qr = genericResults(endpoint, entityUri);
    return qr.toString();
  }

  static public QueryResult cityResults(Sparql endpoint, String entityUri)
      throws SQLException, ClassNotFoundException {
    String query =
        String.format(cityTemplate, entityUri, entityUri, entityUri, entityUri, entityUri);
    return endpoint.query(query);
  }

  static public String cityAsString(Sparql endpoint, String entityUri)
      throws SQLException, ClassNotFoundException {
    QueryResult qr = cityResults(endpoint, entityUri);
    return qr.toString();
  }

  static public QueryResult countryResults(Sparql endpoint, String entityUri)
      throws SQLException, ClassNotFoundException {
    String query =
        String.format(countryTemplate, entityUri, entityUri, entityUri, entityUri, entityUri);
    return endpoint.query(query);
  }

  static public String countryAsString(Sparql endpoint, String entityUri)
      throws SQLException, ClassNotFoundException {
    QueryResult qr = countryResults(endpoint, entityUri);
    return qr.toString();
  }
  static public QueryResult personResults(Sparql endpoint, String entityUri)
      throws SQLException, ClassNotFoundException {
    String query =
        String.format(personTemplate, entityUri, entityUri, entityUri, entityUri, entityUri);
    return endpoint.query(query);
  }

  static public String personAsString(Sparql endpoint, String entityUri)
      throws SQLException, ClassNotFoundException {
    QueryResult qr = personResults(endpoint, entityUri);
    return qr.toString();
  }
  static public QueryResult companyResults(Sparql endpoint, String entityUri)
      throws SQLException, ClassNotFoundException {
    String query =
        String.format(companyTemplate, entityUri, entityUri, entityUri, entityUri, entityUri);
    return endpoint.query(query);
  }

  static public String companyAsString(Sparql endpoint, String entityUri)
      throws SQLException, ClassNotFoundException {
    QueryResult qr = companyResults(endpoint, entityUri);
    return qr.toString();
  }

  static private String companyTemplate =
      "SELECT DISTINCT" +
          "    (GROUP_CONCAT (DISTINCT ?industry2; SEPARATOR=' | ') AS ?industry)\n" +
          "    (GROUP_CONCAT (DISTINCT ?netIncome2; SEPARATOR=' | ') AS ?netIncome)\n" +
          "    (GROUP_CONCAT (DISTINCT ?label2; SEPARATOR=' | ') AS ?label)\n" +
          "    (GROUP_CONCAT (DISTINCT ?comment2; SEPARATOR=' | ') AS ?comment)\n" +
          "    (GROUP_CONCAT (DISTINCT ?numberOfEmployees2; SEPARATOR=' | ') AS ?numberOfEmployees) {\n" +
          "  %s <http://www.w3.org/2000/01/rdf-schema#comment>  ?comment2 .\n" +
          "            FILTER  (lang(?comment2) = 'en') .\n" +
          "  OPTIONAL { %s <http://dbpedia.org/ontology/industry> ?industry2 } .\n" +
          "  OPTIONAL { %s <http://dbpedia.org/ontology/netIncome> ?netIncome2 } .\n" +
          "  OPTIONAL { %s <http://dbpedia.org/ontology/numberOfEmployees> ?numberOfEmployees2 } .\n" +
          "  OPTIONAL { %s <http://www.w3.org/2000/01/rdf-schema#label> ?label2 .\n" +
          "            FILTER (lang(?label2) = 'en') } \n" +
          "} LIMIT 30";
  
  static private String personTemplate =
      "SELECT DISTINCT\n" +
          "    (GROUP_CONCAT (DISTINCT ?birthplace2; SEPARATOR=' | ') AS ?birthplace)  \n" +
          "    (GROUP_CONCAT (DISTINCT ?label2; SEPARATOR=' | ') AS ?label)  \n" +
          "    (GROUP_CONCAT (DISTINCT ?comment2; SEPARATOR=' | ') AS ?comment)  \n" +
          "    (GROUP_CONCAT (DISTINCT ?almamater2; SEPARATOR=' | ') AS ?almamater)  \n" +
          "    (GROUP_CONCAT (DISTINCT ?spouse2; SEPARATOR=' | ') AS ?spouse) {  \n" +
          " %s <http://www.w3.org/2000/01/rdf-schema#comment>  ?comment2 .\n" +
          " FILTER  (lang(?comment2) = 'en') .  \n" +
          " OPTIONAL { %s <http://dbpedia.org/ontology/birthPlace> ?birthplace2 } .  \n" +
          " OPTIONAL { %s <http://dbpedia.org/ontology/almaMater> ?almamater2 } .  \n" +
          " OPTIONAL { %s <http://dbpedia.org/ontology/spouse> ?spouse2 } .  \n" +
          " OPTIONAL { %s  <http://www.w3.org/2000/01/rdf-schema#label> ?label2 . \n" +
          "    FILTER  (lang(?label2) = 'en') }  \n" +
          " } LIMIT 10";

  static private String countryTemplate =
      "SELECT DISTINCT" +
          "   (GROUP_CONCAT (DISTINCT ?areaTotal2; SEPARATOR=' | ') AS ?areaTotal)\n" +
          "   (GROUP_CONCAT (DISTINCT ?label2; SEPARATOR=' | ') AS ?label)\n" +
          "   (GROUP_CONCAT (DISTINCT ?comment2; SEPARATOR=' | ') AS ?comment)\n" +
          "   (GROUP_CONCAT (DISTINCT ?populationDensity2; SEPARATOR=' | ') AS ?populationDensity) {\n" +
          "  %s <http://www.w3.org/2000/01/rdf-schema#comment>  ?comment2 .\n" +
          "                           FILTER  (lang(?comment2) = 'en') .\n" +
          "                     OPTIONAL { %s <http://dbpedia.org/ontology/areaTotal> ?areaTotal2 } .\n" +
          "                     OPTIONAL { %s <http://dbpedia.org/ontology/populationDensity> ?populationDensity2 } .\n" +
          "                     OPTIONAL { %s <http://www.w3.org/2000/01/rdf-schema#label> ?label2 . }\n" +
          "                   } LIMIT 30";

  static private String cityTemplate =
      "SELECT DISTINCT\n" +
          "          (GROUP_CONCAT (DISTINCT ?latitude_longitude2; SEPARATOR=' | ') \n" +
          "              AS ?latitude_longitude) \n" +
          "          (GROUP_CONCAT (DISTINCT ?populationDensity2; SEPARATOR=' | ') AS ?populationDensity) \n" +
          "          (GROUP_CONCAT (DISTINCT ?label2; SEPARATOR=' | ') AS ?label) \n" +
          "          (GROUP_CONCAT (DISTINCT ?comment2; SEPARATOR=' | ') AS ?comment) \n" +
          "          (GROUP_CONCAT (DISTINCT ?country2; SEPARATOR=' | ') AS ?country) { \n" +
          " %s <http://www.w3.org/2000/01/rdf-schema#comment>  ?comment2 . FILTER  (lang(?comment2) = 'en') . \n" +
          " OPTIONAL { %s <http://www.w3.org/2003/01/geo/wgs84_pos#geometry> ?latitude_longitude2 } . \n" +
          " OPTIONAL { %s <http://dbpedia.org/ontology/PopulatedPlace/populationDensity> ?populationDensity2 } . \n" +
          " OPTIONAL { %s <http://dbpedia.org/ontology/country> ?country2 } . \n" +
          " OPTIONAL { %s <http://www.w3.org/2000/01/rdf-schema#label> ?label2 . " +
          "             FILTER  (lang(?label2) = 'en') } \n" +
          " } LIMIT 30\n";


}

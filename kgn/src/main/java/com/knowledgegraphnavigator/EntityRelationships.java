package com.knowledgegraphnavigator;

import com.markwatson.semanticweb.QueryResult;

import java.sql.SQLException;

public class EntityRelationships {

  static public QueryResult results(Sparql endpoint,
                                    String entity1Uri, String entity2Uri)
      throws SQLException, ClassNotFoundException {
    String query =
        String.format("select ?p where { %s ?p %s . FILTER (!regex(str(?p), 'wikiPage', 'i')) } limit 10",
            entity1Uri, entity2Uri);
    return endpoint.query(query);
  }
}

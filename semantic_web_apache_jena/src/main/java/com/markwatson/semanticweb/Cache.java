package com.markwatson.semanticweb;

import java.sql.*;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.derby.client.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Cache {
  public Cache() throws SQLException, ClassNotFoundException {
    Properties props = new Properties();
    String dbName = "./sparqlCache.db";
    conn = DriverManager.getConnection(protocol + dbName
        + ";create=true", props);
    conn.setAutoCommit(true);
    try {
      Statement s = conn.createStatement();
      s.execute("CREATE TABLE cache (query varchar(3000)  PRIMARY KEY, result blob)");
      System.out.println("Created table 'cache'");
    } catch (Exception ex) {
      //System.out.println("Error (Cache()): " + ex.getMessage());
      //System.out.println("Table 'cache' already exists");
    }
  }
  public void saveQueryResultInCache (String query, byte [] result) {
    try {
      if (fetchResultFromCache(query) != null) {
        //System.out.println("Query is already in the cache");
        return;
      }
      Statement s = conn.createStatement();
      PreparedStatement ps = conn.prepareStatement(
          "insert into cache (query, result) values (?, ?)");
      ps.setString(1, query);
      ps.setBytes(2, result);
      ps.executeUpdate();
    } catch (Exception ex) {
      System.out.println("Error (saveQueryResultInCache): " + ex.getMessage());
    }
  }

  public byte []  fetchResultFromCache (String query) {
    try {
      Statement s = conn.createStatement();
      PreparedStatement ps = conn.prepareStatement(
          "select result from cache where query = ?");
      ps.setString(1, query);
      ResultSet rs = ps.executeQuery();
      if (!rs.next()) return null;
      return rs.getBytes(1);
    } catch (Exception ex) {
      System.out.println("Error (fetchResultFromCache): " + ex.getMessage());
      return null;
    }
  }

  private Connection conn = null;
  private String protocol = "jdbc:derby:";

}

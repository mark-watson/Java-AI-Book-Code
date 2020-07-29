package com.knowledgegraphnavigator;

public class Log {
  static public void out(String s) { System.out.println(s); }
  static public StringBuilder sparql  = new StringBuilder();
  static public void clearSparql() { sparql.delete(0, sparql.length()); }
}

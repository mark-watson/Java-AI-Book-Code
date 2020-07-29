package com.markwatson.semanticweb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QueryResult implements Serializable {
  private QueryResult() { }
  public QueryResult(List<String> variableList) {
    this.variableList = variableList;
  }
  public List<String> variableList;
  public List<List<String>> rows = new ArrayList();
  public String toString() {
    StringBuilder sb = new StringBuilder("[QueryResult vars:" + variableList + "\nRows:\n");
    for (List<String> row : rows) {
      sb.append("  " + row + "\n");
    }
    return sb.toString();
  }
}

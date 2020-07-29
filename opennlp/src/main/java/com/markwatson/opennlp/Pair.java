package com.markwatson.opennlp;

public class Pair<X,Y> {
  public Pair(X x, Y y) {
    this.key = x;
    this.val = y;
  }
  public X key;
  public Y val;
  public String toString() {
    return "[" + key + ", " + val + "]";
  }
}

package com.knowledgegraphnavigator;

public class Utils {
  static public String removeBrackets(String s) {
    if (s.startsWith("<")) return s.substring(1, s.length() - 1);
    return s;
  }
}

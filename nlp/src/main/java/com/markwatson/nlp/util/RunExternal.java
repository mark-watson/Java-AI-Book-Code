package com.markwatson.nlp.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunExternal {

  public static void main(String argv[]) {
    try {
      String line;
      Process p = Runtime.getRuntime().exec
        ("echo \"thhe dogg brked\" | /usr/local/bin/aspell  -a list");
      BufferedReader input =
        new BufferedReader
          (new InputStreamReader(p.getInputStream()));
      while ((line = input.readLine()) != null) {
        System.out.println(line);
      }
      input.close();
    }
    catch (Exception err) {
      err.printStackTrace();
    }
  }
}

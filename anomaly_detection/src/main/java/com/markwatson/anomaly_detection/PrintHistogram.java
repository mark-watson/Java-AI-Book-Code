package com.markwatson.anomaly_detection;

/**
 * Created by markw on 10/9/15.
 */
public class PrintHistogram {
  public static void historam(String title, double [][] values, int indexToDisplay, double min, double max, int numBins) {
    int [] bins = new int[numBins];
    for (int i=0; i<values.length; i++) {
      double x = values[i][indexToDisplay];
      int ind = (int) (0.99 * (x - min) * numBins / max);
      bins[ind] += 1;
    }
    System.out.println("\n" + title);
    for (int i=0; i<numBins; i++) System.out.println("" + i + "\t" + bins[i]);
  }
}

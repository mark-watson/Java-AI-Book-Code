package com.markwatson.anomaly_detection;

import java.io.*;
import org.apache.commons.io.FileUtils;

/**
 * Train a deep belief network on the University of Wisconsin Cancer Data Set.
 */
public class WisconsinAnomalyDetection {

  private static boolean PRINT_HISTOGRAMS = true;
  private static int NUM_HISTOGRAM_BINS = 5;

  public static void main(String[] args) throws Exception {

    String [] lines = FileUtils.readFileToString(new File("data/cleaned_wisconsin_cancer_data.csv")).split("\n");
    double [][] training_data = new double[lines.length][];
    int line_count = 0;
    for (String line : lines) {
      String [] sarr = line.split(",");
      double [] xs = new double[10];
      for (int i=0; i<10; i++) xs[i] = Double.parseDouble(sarr[i]);
      for (int i=0; i<9; i++) xs[i] *= 0.1;

      // make the data look more like a gausian (bell curve shaped) distribution:
      double min = 1.e6, max = -1.e6;
      for (int i=0; i<9; i++) {
        xs[i] = Math.log(xs[i] + 1.2);
        if (xs[i] < min) min = xs[i];
        if (xs[i] > max) max = xs[i];
      }
      for (int i=0; i<9; i++) xs[i] = (xs[i] - min) / (max - min);

      xs[9] = (xs[9] - 2) * 0.5; // make target output be [0,1] instead of [2,4]
      training_data[line_count++] = xs;
    }

    if (PRINT_HISTOGRAMS) {
      PrintHistogram.historam("Clump Thickness", training_data, 0, 0.0, 1.0, NUM_HISTOGRAM_BINS);
      PrintHistogram.historam("Uniformity of Cell Size", training_data, 1, 0.0, 1.0, NUM_HISTOGRAM_BINS);
      PrintHistogram.historam("Uniformity of Cell Shape", training_data, 2, 0.0, 1.0, NUM_HISTOGRAM_BINS);
      PrintHistogram.historam("Marginal Adhesion", training_data, 3, 0.0, 1.0, NUM_HISTOGRAM_BINS);
      PrintHistogram.historam("Single Epithelial Cell Size", training_data, 4, 0.0, 1.0, NUM_HISTOGRAM_BINS);
      PrintHistogram.historam("Bare Nuclei", training_data, 5, 0.0, 1.0, NUM_HISTOGRAM_BINS);
      PrintHistogram.historam("Bland Chromatin", training_data, 6, 0.0, 1.0, NUM_HISTOGRAM_BINS);
      PrintHistogram.historam("Normal Nucleoli", training_data, 7, 0.0, 1.0, NUM_HISTOGRAM_BINS);
      PrintHistogram.historam("Mitoses", training_data, 8, 0.0, 1.0, NUM_HISTOGRAM_BINS);
    }

    AnomalyDetection detector = new AnomalyDetection(10, line_count - 1, training_data);

    // the train method will print training results like
    // precision, recall, and F1:
    detector.train();

    // get best model parameters:
    double best_epsilon = detector.bestEpsilon();
    double [] mean_values = detector.muValues();
    double [] sigma_squared = detector.sigmaSquared();

    // to use this model, use the method AnomalyDetection.isAnamoly(double []):

    double [] test_malignant = new double[] {0.5,1,1,0.8,0.5,0.5,0.7,1,0.1};
    double [] test_benign = new double[] {0.5,0.4,0.5,0.1,0.8,0.1,0.3,0.6,0.1};
    boolean malignant_result = detector.isAnamoly(test_malignant);
    boolean benign_result = detector.isAnamoly(test_benign);
    System.out.println("\n\nUsing the trained model:");
    System.out.println("malignant result = " + malignant_result + ", benign result = " + benign_result);
  }
}

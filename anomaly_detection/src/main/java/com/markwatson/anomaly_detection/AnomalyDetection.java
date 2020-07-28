package com.markwatson.anomaly_detection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by markw on 10/7/15.
 */
public class AnomalyDetection {

  public AnomalyDetection() { }

  /**
   * AnomalyDetection is a general purpose class for building anomaly detection
   * models. You should use this type of mdel when you have mostly negative
   * training examples with relatively few positive examples and you need a model
   * that detects postive (anomaly) inputs.
   *
   * @param num_features
   * @param num_training_examples
   * @param training_examples [num_training_examples][num_features]
   */
  public AnomalyDetection(int num_features, int num_training_examples, double [][] training_examples) {
    List<double[]> training = new ArrayList<>();
    List<double []> cross_validation = new ArrayList<>();
    List<double []> testing = new ArrayList<>();
    int outcome_index = num_features - 1; // index of target outcome
    for (int i=0; i<num_training_examples; i++) {
      if (Math.random() < 0.6) { // 60% training
        // Only keep normal (negative) examples in training, except
        // remember the reason for using this algorithm is that it
        // works with many more negative examples than positive
        // examples, and that the algorithm works even with some positive
        // examples mixed into the training set. The random test is to
        // allow about 10% positive examples to get into the training set:
        if (training_examples[i][outcome_index] < 0.5 || Math.random() < 0.1)
          training.add(training_examples[i]);
      } else if (Math.random() < 0.7) {
          cross_validation.add(training_examples[i]);
      } else {
        testing.add(training_examples[i]);
      }
    }
    this.num_training_examples = training.size();
    this.num_cross_validation_examples = cross_validation.size();
    this.num_testing_examples = testing.size();

    this.training_examples = new double[this.num_training_examples][];
    for (int k=0; k<this.num_training_examples; k++) {
      this.training_examples[k] = training.get(k); // [num_training_examples][num_features]
    }

    this.cross_validation_examples = new double[num_cross_validation_examples][];
    for (int k=0; k<num_cross_validation_examples; k++) {
      this.cross_validation_examples[k] = cross_validation.get(k); // [num_training_examples][num_features]
    }

    this.testing_examples = new double[num_testing_examples][];
    for (int k=0; k<num_testing_examples; k++) {
      this.testing_examples[k] = testing.get(k); // [num_training_examples][num_features]
    }

    this.mu = new double[num_features];
    this.sigma_squared = new double[num_features];
    this.num_features = num_features;
    for (int nf = 0; nf < this.num_features; nf++) { //
      double sum = 0;
      for (int nt = 0; nt < this.num_training_examples; nt++) sum += training_examples[nt][nf];
      this.mu[nf] = sum / this.num_training_examples;
    }
  }

  public double [] muValues()     { return mu; }
  public double [] sigmaSquared() { return sigma_squared; }
  public double bestEpsilon()     { return best_epsilon; }

  /**
   *
   * Train the model using a range of epsilon values. Epsilon is a
   * hyper parameter that we want to find a value that
   * minimizes the error count.
   */
  public void train() {
    double best_error_count = 1e10;
    for (int epsilon_loop=0; epsilon_loop<40; epsilon_loop++) {
      double epsilon = 0.05 + 0.01 * epsilon_loop;
      double error_count = train_helper(epsilon);
      if (error_count < best_error_count) {
        best_error_count = error_count;
        best_epsilon = epsilon;
      }
    }
    System.out.println("\n**** Best epsilon value = " + best_epsilon );

    // retrain for the best epsilon setting the maximum likelyhood parameters
    // which are now in epsilon, mu[] and sigma_squared[]:
    train_helper(best_epsilon);

    // finally, we are ready to see how the model performs with test data:
    test(best_epsilon);
  }

  /**
   * calculate probability p(x; mu, sigma_squared)
   *
   * @param x - example vector
   * @return
   */
  private double p(double [] x) {
    double sum = 0;
    // use (num_features - 1) to skip target output:
    for (int nf=0; nf<num_features - 1; nf++) {
      sum += (1.0 / (SQRT_2_PI * sigma_squared[nf])) * Math.exp(- (x[nf] - mu[nf]) * (x[nf] - mu[nf]));
    }
    return sum / num_features;
  }

  /**
   * returns 1 if input vector is an anoomaly
   *
   * @param x - example vector
   * @return
   */
  public boolean isAnamoly(double [] x) {
    double sum = 0;
    // use (num_features - 1) to skip target output:
    for (int nf=0; nf<num_features - 1; nf++) {
      sum += (1.0 / (SQRT_2_PI * sigma_squared[nf])) * Math.exp(- (x[nf] - mu[nf]) * (x[nf] - mu[nf]));
    }
    return (sum / num_features) < best_epsilon;
  }

  private double train_helper(double epsilon) {
    // use (num_features - 1) to skip target output:
    for (int nf = 0; nf < this.num_features - 1; nf++) {
      double sum = 0;
      for (int nt=0; nt<this.num_training_examples; nt++) {
        sum += (this.training_examples[nt][nf] - mu[nf]) * (this.training_examples[nt][nf] - mu[nf]);
      }
      sigma_squared[nf] = (1.0 / num_features) * sum;
    }
    double cross_validation_error_count = 0;
    for (int nt=0; nt<this.num_cross_validation_examples; nt++) {
      double[] x = this.cross_validation_examples[nt];
      double calculated_value = p(x);
      if (x[9] > 0.5) { // target training output is ANOMALY
        // if the calculated value is greater than epsilon
        // then this x vector is not an anomaly (e.g., it
        // is a normal sample):
        if (calculated_value > epsilon) cross_validation_error_count += 1;
      } else { // target training output is NORMAL
        if (calculated_value < epsilon) cross_validation_error_count += 1;
      }
    }
    System.out.println("   cross_validation_error_count = " + cross_validation_error_count + " for epsilon = " + epsilon);
    return cross_validation_error_count;
  }

  private double test(double epsilon) {
    double num_false_positives = 0, num_false_negatives = 0;
    double num_true_positives = 0, num_true_negatives = 0;
    for (int nt=0; nt<this.num_testing_examples; nt++) {
      double[] x = this.testing_examples[nt];
      double calculated_value = p(x);
      if (x[9] > 0.5) { // target training output is ANOMALY
        if (calculated_value > epsilon) num_false_negatives++;
        else                            num_true_positives++;
      } else { // target training output is NORMAL
        if (calculated_value < epsilon) num_false_positives++;
        else                            num_true_negatives++;
      }
    }
    double precision = num_true_positives / (num_true_positives + num_false_positives);
    double recall = num_true_positives / (num_true_positives + num_false_negatives);
    double F1 = 2 * precision * recall / (precision + recall);

    System.out.println("\n\n -- best epsilon = " + this.best_epsilon);
    System.out.println(" -- number of test examples = " + this.num_testing_examples);
    System.out.println(" -- number of false positives = " + num_false_positives);
    System.out.println(" -- number of true positives = " + num_true_positives);
    System.out.println(" -- number of false negatives = " + num_false_negatives);
    System.out.println(" -- number of true negatives = " + num_true_negatives);
    System.out.println(" -- precision = " + precision);
    System.out.println(" -- recall = " + recall);
    System.out.println(" -- F1 = " + F1);
    return F1;
  }

  double best_epsilon = 0.02;
  private double [] mu;  // [num_features]
  private double [] sigma_squared; // [num_features]
  private int num_features;
  private static double SQRT_2_PI = 2.50662827463;


  private double[][] training_examples; // [num_features][num_training_examples]
  private double[][] cross_validation_examples; // [num_features][num_training_examples]
  private double[][] testing_examples; // [num_features][num_training_examples]
  private int num_training_examples;
  private int num_cross_validation_examples;
  private int num_testing_examples;

}

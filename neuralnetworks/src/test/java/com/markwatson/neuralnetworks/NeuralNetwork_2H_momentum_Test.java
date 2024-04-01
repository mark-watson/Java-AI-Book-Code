package com.markwatson.neuralnetworks;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class NeuralNetwork_2H_momentum_Test extends TestCase {
  /**
   * Create the test case
   *
   * @param testName name of the test case
   */
  public NeuralNetwork_2H_momentum_Test(String testName)
  {
    super( testName );
  }

  static float[] in1 = {0.1f,  0.1f, 0.9f};
  static float[] in2 = {0.1f,  0.9f, 0.1f};
  static float[] in3 = {0.9f,  0.1f, 0.1f};

  static float[] out1 = {0.9f, 0.1f, 0.1f};
  static float[] out2 = {0.1f, 0.1f, 0.9f};
  static float[] out3 = {0.1f, 0.9f, 0.1f};

  static float[] test1 = {0.1f, 0.1f, 0.9f};
  static float[] test2 = {0.1f, 0.9f, 0.1f};
  static float[] test3 = {0.9f, 0.1f, 0.1f};

  void test_recall(Neural_2H_momentum nn, float[] inputs) {
    float[] results = nn.recall(inputs);
    System.out.print("Test case: ");
    for (float input : inputs) System.out.print(pp(input) + " ");
    System.out.print(" results: ");
    for (float result : results) System.out.print(pp(result) + " ");
    System.out.println();
  }


  /**
   * @return the suite of tests being tested
   */
  public static Test suite()
  {
    return new TestSuite( NeuralNetwork_2H_momentum_Test.class );
  }

  /**
   * Test that is just for side effect printouts:
   */
  public void testTraining() {
    Neural_2H_momentum nn = new Neural_2H_momentum(3, 3, 3, 3);
    nn.addTrainingExample(in1, out1);
    nn.addTrainingExample(in2, out2);
    nn.addTrainingExample(in3, out3);
    double error = 0;
    for (int i = 0; i < 10000; i++) {
      error += nn.train();
      if (i > 0 && (i % 1000 == 0)) {
        error /= 100;
        System.out.println("cycle " + i + " error is " + error);
        error = 0;
      }
    }
    System.out.println("Test results should rotate inputs:");
    test_recall(nn, test1);
    test_recall(nn, test2);
    test_recall(nn, test3);
  }

  public static String pp(float x) {
    String s = new String("" + x + "00");
    int index = s.indexOf(".");
    if (index > -1) s = s.substring(0, index + 3);
    if (s.startsWith("-") == false) s = " " + s;
    return s;
  }
}
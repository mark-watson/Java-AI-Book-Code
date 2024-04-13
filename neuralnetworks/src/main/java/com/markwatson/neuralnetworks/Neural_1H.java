package com.markwatson.neuralnetworks;

import java.util.*;
import java.io.*;

/**
 * Back-propagation neural network with 1 hidden layer
 * <p>
 * <p/>
 * Copyright 1998-2012 by Mark Watson. All rights reserved.
 * <p/>
 * This software is can be used under either of the following licenses:
 * <p/>
 * 1. LGPL v3<br/>
 * 2. Apache 2
 * <p/>
 */
public class Neural_1H implements Serializable {

  protected int numInputs;
  protected int numHidden;
  protected int numOutputs;

  protected int numTraining;

  public float inputs[];
  public float hidden[];
  public float outputs[];

  public float W1[][];
  public float W2[][];

  protected float output_errors[];
  protected float hidden_errors[];

  public float learningRate = 0.2f;

  transient protected Vector<float[]> inputTraining = new Vector<>();
  transient protected Vector<float[]> outputTraining = new Vector<>();


  public Neural_1H(int num_in, int num_hidden, int num_output) {
    numInputs = num_in;
    numHidden = num_hidden;
    numOutputs = num_output;
    inputs = new float[numInputs];
    hidden = new float[numHidden];
    outputs = new float[numOutputs];
    W1 = new float[numInputs][numHidden];
    W2 = new float[numHidden][numOutputs];
    randomizeWeights();

    output_errors = new float[numOutputs];
    hidden_errors = new float[numHidden];
  }

  public void addTrainingExample(float[] inputs, float[] outputs) {
    if (inputs.length != numInputs || outputs.length != numOutputs) {
      System.out.println("addTrainingExample(): array size is wrong");
      return;
    }
    inputTraining.addElement(inputs);
    outputTraining.addElement(outputs);
  }

  public void setLearningRate(float f) {
    learningRate = f;
  }

  public void randomizeWeights() {
    // Randomize weights here:
    for (int ii = 0; ii < numInputs; ii++)
      for (int hh = 0; hh < numHidden; hh++)
        W1[ii][hh] =
            (float) Math.random() - 0.5f;
    for (int hh = 0; hh < numHidden; hh++)
      for (int oo = 0; oo < numOutputs; oo++)
        W2[hh][oo] =
            (float) Math.random() - 0.5f;
  }

  public void slightlyRandomizeWeights() {
    // Randomize weights here:
    for (int ii = 0; ii < numInputs; ii++)
      for (int hh = 0; hh < numHidden; hh++)
        W1[ii][hh] +=
            0.2f * (float) Math.random() - 0.1f;
    for (int ii = 0; ii < numHidden; ii++)
      for (int hh = 0; hh < numOutputs; hh++)
        W2[ii][hh] +=
            0.2f * (float) Math.random() - 0.1f;
  }

  public void jiggleWeights(float factor) {
    // Randomize weights here:
    for (int ii = 0; ii < numInputs; ii++)
      for (int hh = 0; hh < numHidden; hh++)
        W1[ii][hh] +=
            factor * (float) Math.random() - (factor / 2);
    for (int hh = 0; hh < numHidden; hh++)
      for (int oo = 0; oo < numOutputs; oo++)
        W2[hh][oo] +=
            factor * (float) Math.random() - (factor / 2);
  }

  public float[] recall(float[] in) {
    for (int i = 0; i < numInputs; i++) inputs[i] = in[i];
    forwardPass();
    float[] ret = new float[numOutputs];
    for (int i = 0; i < numOutputs; i++) ret[i] = outputs[i];
    return ret;
  }

  public void forwardPass() {
    int i, h, o;
    for (h = 0; h < numHidden; h++) {
      hidden[h] = 0.0f;
    }
    for (i = 0; i < numInputs; i++) {
      for (h = 0; h < numHidden; h++) {
        hidden[h] +=
            inputs[i] * W1[i][h];
      }
    }
    for (o = 0; o < numOutputs; o++)
      outputs[o] = 0.0f;
    for (h = 0; h < numHidden; h++) {
      for (o = 0; o < numOutputs; o++) {
        outputs[o] +=
            sigmoid(hidden[h]) * W2[h][o];
      }
    }
    for (o = 0; o < numOutputs; o++)
      outputs[o] = sigmoid(outputs[o]);
  }

  public float train() {
    return train(inputTraining, outputTraining);
  }

  // for debug graphics: train only one example at a time:
  private int current_example = 0;
  private int count_control_randomize_weights = 0;

  public float train(Vector<float[]> v_ins, Vector<float[]> v_outs) {
    int i, h, o;
    float error = 0.0f;
    int num_cases = v_ins.size();
    count_control_randomize_weights += 1;
    //for (int example=0; example<num_cases; example++) {
    // zero out error arrays:
    for (h = 0; h < numHidden; h++)
      hidden_errors[h] = 0.0f;
    for (o = 0; o < numOutputs; o++)
      output_errors[o] = 0.0f;
    // copy the input values:
    for (i = 0; i < numInputs; i++) {
      inputs[i] = ((float[]) v_ins.elementAt(current_example))[i];
    }
    // copy the ouytput values:
    float[] outs = (float[]) v_outs.elementAt(current_example);

    // perform a forward pass through the network:

    forwardPass();

    for (o = 0; o < numOutputs; o++) {
      output_errors[o] =
          (outs[o] -
              outputs[o])
              * sigmoidP(outputs[o]);
    }
    for (h = 0; h < numHidden; h++) {
      hidden_errors[h] = 0.0f;
      for (o = 0; o < numOutputs; o++) {
        hidden_errors[h] +=
            output_errors[o] * W2[h][o];
      }
    }
    for (h = 0; h < numHidden; h++) {
      hidden_errors[h] =
          hidden_errors[h] * sigmoidP(hidden[h]);
    }
    // update the hidden to output weights:
    for (o = 0; o < numOutputs; o++) {
      for (h = 0; h < numHidden; h++) {
        W2[h][o] +=
            learningRate * output_errors[o] * hidden[h];
      }
    }
    // update the input to hidden weights:
    for (h = 0; h < numHidden; h++) {
      for (i = 0; i < numInputs; i++) {
        W1[i][h] +=
            learningRate * hidden_errors[h] * inputs[i];
      }
    }
    for (o = 0; o < numOutputs; o++) {
      error += Math.abs(outs[o] - outputs[o]);
    }
    current_example++;
    if (current_example >= num_cases) current_example = 0;
    if ((count_control_randomize_weights > 500) && (error > 1)) {
      count_control_randomize_weights = 0;
      randomizeWeights();
      System.out.println("Weights randomized (training was not converging).");
    }
    return error;
  }


  protected float sigmoid(float x) {
    return
        (float) (1.0f / (1.0f + Math.exp((double) (-x))));
    //     (float)((1.0f/(1.0f+Math.exp((double)(-x))))-0.5f);
  }

  protected float sigmoidP(float x) {
    double z = sigmoid(x); // + 0.5f;
    return (float) (z * (1.0f - z));
  }

}

package com.markwatson.neuralnetworks;

import java.util.*;
import java.io.*;

/**
 * Back-propagation neural network with 2 hidden layers and momentum
 *
 * <p/>
 * Copyright 1998-2012 by Mark Watson. All rights reserved.
 * <p/>
 * This software is can be used under either of the following licenses:
 * <p/>
 * 1. LGPL v3<br/>
 * 2. Apache 2
 * <p/>
 */public class Neural_2H_momentum implements Serializable {

    private static final long serialVersionUID = 5869773395153615662L;
    protected int numInputs;
    protected int numHidden1;
    protected int numHidden2;
    protected int numOutputs;

    protected int numTraining;

    public float inputs[];
    public float hidden1[];
    public float hidden2[];
    public float outputs[];

    public float W1[][];
    public float W2[][];
    public float W3[][];

    // last delta weights for momentum term:
    protected float W1_last_delta[][];
    protected float W2_last_delta[][];
    protected float W3_last_delta[][];

    protected float output_errors[];
    protected float hidden1_errors[];
    protected float hidden2_errors[];

    transient protected ArrayList<float[]> inputTraining = new ArrayList<>();
    transient protected ArrayList<float[]> outputTraining = new ArrayList<>();

    public float TRAINING_RATE = 0.2f;
    private float alpha = 0f;  // momentum scaling term that is applied to last delta weight

    // use a reasonable default momentum term (alpha):
    public Neural_2H_momentum(int num_in, int num_hidden1, int num_hidden2, int num_output) {
        this(num_in, num_hidden1, num_hidden1, num_output, 0.6f);
    }

    public Neural_2H_momentum(int num_in, int num_hidden1, int num_hidden2, int num_output,
                       float alpha) {
        this.alpha = alpha;
        numInputs = num_in;
        numHidden1 = num_hidden1;
        numHidden2 = num_hidden2;
        numOutputs = num_output;
        inputs = new float[numInputs];
        hidden1 = new float[numHidden1];
        hidden2 = new float[numHidden2];
        outputs = new float[numOutputs];
        W1 = new float[numInputs][numHidden1];
        W2 = new float[numHidden1][numHidden2];
        W3 = new float[numHidden2][numOutputs];
        W1_last_delta = new float[numInputs][numHidden1];
        W2_last_delta = new float[numHidden1][numHidden2];
        W3_last_delta = new float[numHidden2][numOutputs];
        randomizeWeights();

        output_errors = new float[numOutputs];
        hidden1_errors = new float[numHidden1];
        hidden2_errors = new float[numHidden2];
    }

    public void addTrainingExample(float[] inputs, float[] outputs) {
        if (inputs.length != numInputs || outputs.length != numOutputs) {
            System.out.println("addTrainingExample(): array size is wrong");
            return;
        }
        //System.out.println("addTrainingExample(): inputs: " + Arrays.toString(inputs));
        //System.out.println("addTrainingExample(): outputs: " + Arrays.toString(outputs));
        inputTraining.add(inputs);
        outputTraining.add(outputs);
    }

    public void setLearningRate(float f) {
        TRAINING_RATE = f;
    }
    
    public void randomizeWeights() {
        // Randomize weights here:
        for (int ii = 0; ii < numInputs; ii++)
            for (int hh = 0; hh < numHidden1; hh++)
                W1[ii][hh] =
                        2f * (float) Math.random() - 1f;
        for (int ii = 0; ii < numHidden1; ii++)
            for (int hh = 0; hh < numHidden2; hh++)
                W2[ii][hh] =
                        2f * (float) Math.random() - 1f;
        for (int hh = 0; hh < numHidden2; hh++)
            for (int oo = 0; oo < numOutputs; oo++)
                W3[hh][oo] =
                        2f * (float) Math.random() - 1f;
    }

    public void slightlyRandomizeWeights() {
        // Randomize weights here:
        for (int ii = 0; ii < numInputs; ii++)
            for (int hh = 0; hh < numHidden1; hh++)
                W1[ii][hh] +=
                        0.2f * (float) Math.random() - 0.1f;
        for (int ii = 0; ii < numHidden1; ii++)
            for (int hh = 0; hh < numHidden2; hh++)
                W2[ii][hh] +=
                        0.2f * (float) Math.random() - 0.1f;
        for (int hh = 0; hh < numHidden2; hh++)
            for (int oo = 0; oo < numOutputs; oo++)
                W3[hh][oo] +=
                        0.2f * (float) Math.random() - 0.1f;
    }

    public float[] recall(float[] in) {
        //System.out.println("recall(" + Arrays.toString(inputs) + ")");
        for (int i = 0; i < numInputs; i++) inputs[i] = in[i];
        forwardPass();
        float[] ret = new float[numOutputs];
        for (int i = 0; i < numOutputs; i++) ret[i] = outputs[i];
        return ret;
    }

    public void forwardPass() {
        int i, h, o;
        for (h = 0; h < numHidden1; h++) {
            hidden1[h] = 0.0f;
        }
        for (h = 0; h < numHidden2; h++) {
            hidden2[h] = 0.0f;
        }
        for (i = 0; i < numInputs; i++) {
            for (h = 0; h < numHidden1; h++) {
                hidden1[h] +=
                        inputs[i] * W1[i][h];
            }
        }
        for (i = 0; i < numHidden1; i++) {
            for (h = 0; h < numHidden2; h++) {
                hidden2[h] +=
                        hidden1[i] * W2[i][h];
            }
        }
        for (o = 0; o < numOutputs; o++)
            outputs[o] = 0.0f;
        for (h = 0; h < numHidden2; h++) {
            for (o = 0; o < numOutputs; o++) {
                outputs[o] +=
                        sigmoid(hidden2[h]) * W3[h][o];
            }
        }
    }

    public float train() {
        return train(inputTraining, outputTraining);
    }

    private int current_example = 0;

    public float train(ArrayList ins, ArrayList v_outs) {
        int i, h, o;
        float error = 0.0f;
        int num_cases = ins.size();
        //for (int example=0; example<num_cases; example++) {
        // zero out error arrays:
        for (h = 0; h < numHidden1; h++)
            hidden1_errors[h] = 0.0f;
        for (h = 0; h < numHidden2; h++)
            hidden2_errors[h] = 0.0f;
        for (o = 0; o < numOutputs; o++)
            output_errors[o] = 0.0f;
        // copy the input values:
        for (i = 0; i < numInputs; i++) {
            inputs[i] = ((float[]) ins.get(current_example))[i];
        }
        // copy the output values:
        float[] outs = (float[]) v_outs.get(current_example);

        // perform a forward pass through the network:

        forwardPass();

        for (o = 0; o < numOutputs; o++) {
            output_errors[o] =
                    (outs[o] -
                    outputs[o])
                    * sigmoidP(outputs[o]);
        }
        for (h = 0; h < numHidden2; h++) {
            hidden2_errors[h] = 0.0f;
            for (o = 0; o < numOutputs; o++) {
                hidden2_errors[h] +=
                        output_errors[o] * W3[h][o];
            }
        }
        for (h = 0; h < numHidden1; h++) {
            hidden1_errors[h] = 0.0f;
            for (o = 0; o < numHidden2; o++) {
                hidden1_errors[h] +=
                        hidden2_errors[o] * W2[h][o];
            }
        }
        for (h = 0; h < numHidden2; h++) {
            hidden2_errors[h] =
                    hidden2_errors[h] * sigmoidP(hidden2[h]);
        }
        for (h = 0; h < numHidden1; h++) {
            hidden1_errors[h] =
                    hidden1_errors[h] * sigmoidP(hidden1[h]);
        }
        // update the hidden2 to output weights:
        for (o = 0; o < numOutputs; o++) {
            for (h = 0; h < numHidden2; h++) {
                W3[h][o] +=
                        TRAINING_RATE * output_errors[o] * hidden2[h] +
                        // apply the momentum term:
                        alpha * W3_last_delta[h][o];
                W3[h][o] = clampWeight(W3[h][o]);
                W3_last_delta[h][o] = TRAINING_RATE * output_errors[o] * hidden2[h];
            }
        }
        // update the hidden1 to hidden2 weights:
        for (o = 0; o < numHidden2; o++) {
            for (h = 0; h < numHidden1; h++) {
                W2[h][o] +=
                        TRAINING_RATE * hidden2_errors[o] * hidden1[h] +
                        // apply the momentum term:
                        alpha * W2_last_delta[h][o];
                W2[h][o] = clampWeight(W2[h][o]);
                W2_last_delta[h][o] = TRAINING_RATE * hidden2_errors[o] * hidden1[h];
            }
        }
        // update the input to hidden1 weights:
        for (h = 0; h < numHidden1; h++) {
            for (i = 0; i < numInputs; i++) {
                W1[i][h] +=
                        TRAINING_RATE * hidden1_errors[h] * inputs[i] +
                        // apply the momentum term:
                        alpha * W1_last_delta[i][h];
                W1[i][h] = clampWeight(W1[i][h]);
                W1_last_delta[i][h] = TRAINING_RATE * hidden1_errors[h] * inputs[i];
            }
        }
        for (o = 0; o < numOutputs; o++) {
            error += Math.abs(outs[o] - outputs[o]);
            //error += Math.abs(output_errors[o]);
        }
        current_example++;
        if (current_example >= num_cases) current_example = 0;
        return error;
    }

    public float clampWeight(float weigth) {
        float ret = weigth;
        if (ret < -10) ret = -10;
        if (ret > 10)  ret =  10;
        return ret;
    }
    protected float sigmoid(float x) {
        return
                (float) (1.0f / (1.0f + Math.exp((double) (-x))));
    }

    protected float sigmoidP(float x) {
        double z = sigmoid(x); //  + TRAINING_RATE;
        return (float) (z * (1.0f - z));
    }

}

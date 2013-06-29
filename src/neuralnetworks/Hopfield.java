package neuralnetworks;

import java.util.*;

/**
 * Hopfield neural network
 *
 * <p/>
 * Copyright 1998-2012 by Mark Watson. All rights reserved.
 * <p/>
 * This software is can be used under either of the following licenses:
 * <p/>
 * 1. LGPL v3<br/>
 * 2. Apache 2
 * <p/>
 */
public class Hopfield {

    public Hopfield(int numInputs) {
        this.numInputs = numInputs;
        weights = new float[numInputs][numInputs];
        inputCells = new float[numInputs];
        tempStorage = new float[numInputs];
    }

    public void addTrainingData(float[] data) {
        trainingData.addElement(data);
    }

    public void train() {
        for (int j = 1; j < numInputs; j++) {
            for (int i = 0; i < j; i++) {
                for (int n = 0; n < trainingData.size(); n++) {
                    float[] data = (float[]) trainingData.elementAt(n);
                    float temp1 = adjustInput(data[i]) * adjustInput(data[j]);
                    float temp = truncate(temp1 + weights[j][i]);
                    weights[i][j] = weights[j][i] = temp;
                }
            }
        }
        for (int i = 0; i < numInputs; i++) {
            tempStorage[i] = 0.0f;
            for (int j = 0; j < i; j++) {
                tempStorage[i] += weights[i][j];
            }
        }
    }

    public float[] recall(float[] pattern, int numIterations) {
        for (int i = 0; i < numInputs; i++) inputCells[i] = pattern[i];
        for (int ii = 0; ii < numIterations; ii++) {
            for (int i = 0; i < numInputs; i++) {
                if (deltaEnergy(i) > 0.0f) {
                    inputCells[i] = 1.0f;
                } else {
                    inputCells[i] = -1.0f;
                }
            }
        }
        return inputCells;
    }

    private float adjustInput(float x) {
        if (x < 0.0f) return -1.0f;
        return 1.0f;
    }

    private float truncate(float x) {
        //return Math.round(x);
        int i = (int) x;
        return (float) i;
    }

    private float deltaEnergy(int index) {
        float temp = 0.0f;
        for (int j = 0; j < numInputs; j++) {
            temp += weights[index][j] * inputCells[j];
        }
        return 2.0f * temp - tempStorage[index];
    }

    int numInputs;
    Vector trainingData = new Vector();
    float[][] weights;
    float[] tempStorage;
    float[] inputCells;
}

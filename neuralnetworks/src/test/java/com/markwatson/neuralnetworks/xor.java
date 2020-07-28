package com.markwatson.neuralnetworks;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

// 3/7/2004: note: someone asked for an XOR example...  -Mark

public class xor {
    static float FALSE = 0.01f;
    static float TRUE  = 0.99f;

    static float[] in1 = {FALSE, FALSE};
    static float[] in2 = {FALSE, TRUE};
    static float[] in3 = {TRUE, FALSE};
    static float[] in4 = {TRUE, TRUE};

    static float[] out1 = {FALSE};
    static float[] out2 = {TRUE};
    static float[] out3 = {TRUE};
    static float[] out4 = {FALSE};

    static float[] test1 = {FALSE, TRUE};
    static float[] test2 = {TRUE, FALSE};
    static float[] test3 = {TRUE, TRUE};

    public static void main(String[] args) {
        Neural_1H nn = new Neural_1H(2, 3, 1);
        nn.addTrainingExample(in1, out1);
        nn.addTrainingExample(in3, out3);
        nn.addTrainingExample(in2, out2);
        nn.addTrainingExample(in4, out4);
        // loop until we get a low enough error:
        try_again: for (int iter = 0; iter < 500; iter++) {
            nn.randomizeWeights();
            System.out.println("\nStarting with a new random set of weights (iter="+iter+")");
            float weightJiggleFactor = 0.15f;
            double learningRate = 0.4; // 0.15;
            float error = 0;
            for (long i = 0; i < 2000000; i++) {
                nn.jiggleWeights(weightJiggleFactor);
                weightJiggleFactor *= 0.9999;
                nn.setLearningRate((float) learningRate);
                learningRate *= 0.999995;
                if (learningRate < 0.08f) learningRate = 0.08f;
                if (weightJiggleFactor < 0.0002f) weightJiggleFactor = 0.02f;
                error += nn.train();
                //if (error > 0.25f) weightJiggleFactor = 0.5f;
                //if (error > 0.31f) nn.randomizeWeights();
                if (i>0 && i % 100 == 0) {
                    error /= 100;
                    //System.out.println("cycle " + i + " error is " + error + ", learningRate=" + learningRate + ", weightJiggleFactor=" + weightJiggleFactor);
                    // test to see if this set of initial random weights is
                    // producing poor results - if so, bail and start with a new set
                    // of weights:
                    if (i > 30000 & error > 0.38f) continue try_again;
                    if (i > 90000 & error > 0.28f) continue try_again;
                    if (i >150000 & error > 0.21f) continue try_again;
                    if (i >350000 & error > 0.18f) continue try_again;
                    // if the error is low enough, simply stop training now:
                    if (error < 0.1)  break try_again;
                    error = 0;
                }
            }
        }
        test_recall(nn, test1);
        test_recall(nn, test2);
        test_recall(nn, test3);
    }

    public static void test_recall(Neural_1H nn, float[] inputs) {
        float[] results = nn.recall(inputs);
        System.out.print("Test case: ");
        for (int i = 0; i < inputs.length; i++) System.out.print(pp(inputs[i]) + " ");
        System.out.print(" results: ");
        for (int i = 0; i < results.length; i++) System.out.print(pp(results[i]) + " ");
        System.out.println();
    }

    public static String pp(float x) {
        String s = new String("" + x + "00");
        int index = s.indexOf(".");
        if (index > -1) s = s.substring(0, index + 3);
        if (s.startsWith("-") == false) s = " " + s;
        return s;
    }
}

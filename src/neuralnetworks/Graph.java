package neuralnetworks;

import javax.swing.*;
import java.awt.*;

/**
 * Title:        Graph<p>
 * Description:  Simple program to produce a graph for the book<p>
 * Copyright:    Copyright (c) Mark Watson<p>
 * Company:      <p>
 * @author Mark Watson
 * @version 1.0
 */


public class Graph extends JFrame {
    GraphPanel jPanel1;
    float[] data1;
    float[] data2;

    public Graph() {
        try {
            int size = 500;
            data1 = new float[size];
            data2 = new float[size];
            float xmin = -5;
            float xmax = 5;
            for (int i = 0; i < size; i++) {
                float x = i;
                x = xmin + x * (xmax - xmin) / (float) size;
                data1[i] = sigmoid(x);
                data2[i] = sigmoidP(x);
            }
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
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


    public static void main(String[] args) {
        Graph untitled11 = new Graph();
    }

    private void jbInit() throws Exception {
        jPanel1 = new GraphPanel(data1, data2);
        jPanel1.setBackground(Color.white);
        this.setDefaultCloseOperation(3);
        this.getContentPane().add(jPanel1, BorderLayout.CENTER);
        setSize(550, 300);
        jPanel1.setVisible(true);
        setVisible(true);
    }
}

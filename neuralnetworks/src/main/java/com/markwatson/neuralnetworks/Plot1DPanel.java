package com.markwatson.neuralnetworks;


import javax.swing.*;
import java.awt.*;

public class Plot1DPanel extends java.awt.Canvas { // JPanel {

    public Plot1DPanel(int num, float min, float max, float[] values) {
        super();
        this.num = num;
        this.min = min;
        this.max = max;
        this.values = values;
        colors = new Color[100];
        for (int i = 0; i < 100; i++) {
            float x = 1.0f - ((float) i) * 0.0096f;
            colors[i] = new Color(x, x, x);
        }
        this.setBackground(Color.white);
    }

    private int num;
    private float min, max;
    private float temp;
    private float[] values = null;
    private Color[] colors;

    //public void plot(float [] values) {
    //}
    public void paint(Graphics g) {
        //System.out.println("Plot1DPanel: values="+values);
        if (values == null) return;
        int delta_width = this.getWidth() / num;
        int delta_height = this.getHeight() / num;
        for (int i = 0; i < num; i++) {
            //System.out.println(this.toString() + ", values[" + i + "]=" + values[i]);
            temp = 100.0f * (values[i] - min) / (max - min);
            int ii = (int) temp;
            if (ii < 0) ii = 0;
            if (ii > 99) ii = 99;
            g.setColor(colors[ii]);
            g.fillRect(i * delta_width, 0, delta_width, delta_height);
            g.setColor(Color.black);
            g.drawRect(i * delta_width, 0, delta_width, delta_height);
            }
    }
}

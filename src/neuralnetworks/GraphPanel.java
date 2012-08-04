package neuralnetworks;


/**
 * Title:        <p>
 * Description:  <p>
 * Copyright:    Copyright (c) <p>
 * Company:      <p>
 * @author
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;

public class GraphPanel extends java.awt.Canvas { // JPanel {

    public GraphPanel(float[] data1, float[] data2) {
        super();
        this.data1 = data1;
        this.data2 = data2;
    }

    Color black = new Color(0, 0, 0);
    float[] data1;
    float[] data2;

    public void paint(Graphics g) {
        if (data1 == null || data2 == null) return;
        int width = this.getWidth();
        int height = this.getHeight();
        System.out.println("height=" + height);
        float min = 99999999.9f;
        float max = -min;
        int maxindex = 0;
        float maxval = 0.0f;
        for (int i = 0; i < data1.length; i++) { // assume length of data1 and data2 are the same
            if (min > data1[i]) min = data1[i];
            if (max < data1[i]) max = data1[i];
            if (min > data2[i]) min = data2[i];
            if (max < data2[i]) max = data2[i];
        }
        System.out.println("min=" + min + ", max=" + max);
        g.setColor(Color.red);
        for (int i = 0; i < data1.length - 1; i++) {
            float y1 = height - 5 - 0.95f * height * ((data1[i] - min) / (max - min));
            float y2 = height - 5 - 0.95f * height * ((data1[i + 1] - min) / (max - min));
            //System.out.println("data["+i+"]="+data[i]+", y1="+y1+", y2="+y2);
            g.drawLine(i + 20, (int) y1, i + 21, (int) y2);
            y1 = height - 5 - 0.95f * height * ((data2[i] - min) / (max - min));
            y2 = height - 5 - 0.95f * height * ((data2[i + 1] - min) / (max - min));
            //System.out.println("data["+i+"]="+data[i]+", y1="+y1+", y2="+y2);
            g.drawLine(i + 20, (int) y1, i + 21, (int) y2);
        }
        float yzero = height - 5 - 0.95f * height * ((0.0f - min) / (max - min));
        g.setColor(black);
        g.drawLine(20, (int) yzero, data2.length + 19, (int) yzero);
        g.drawLine(width / 2, height / 2 - 118, width / 2, height / 2 + 118);
        g.drawString("Sigmoid", width / 2 + 100, height / 4 - 10);
        g.drawString("SigmoidP", width / 2 +60, 3 * height / 4 + 10);
        g.drawString("-5", 4, (int) yzero);
        g.drawString("5", width - 19, (int) yzero);
        g.drawString("1.0", width / 2 - 7, 12);
        g.drawString("0.0", width / 2 - 9, height - 5);
    }
}

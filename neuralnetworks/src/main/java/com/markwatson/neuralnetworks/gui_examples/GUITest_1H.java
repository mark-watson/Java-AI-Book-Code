package com.markwatson.neuralnetworks.gui_examples;

import com.markwatson.neuralnetworks.Neural_1H;
import com.markwatson.neuralnetworks.Plot1DPanel;
import com.markwatson.neuralnetworks.Plot2DPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUITest_1H extends JFrame {
    static float[] in1 = {0.1f, 0.1f, 0.9f};
    static float[] in2 = {0.1f, 0.9f, 0.1f};
    static float[] in3 = {0.9f, 0.1f, 0.1f};

    static float[] out1 = {0.9f, 0.1f, 0.1f};
    static float[] out2 = {0.1f, 0.1f, 0.9f};
    static float[] out3 = {0.1f, 0.9f, 0.1f};

    static float[] test1 = {0.1f, 0.1f, 0.9f};
    static float[] test2 = {0.1f, 0.9f, 0.1f};
    static float[] test3 = {0.9f, 0.1f, 0.1f};


    Neural_1H nn = new Neural_1H(3, 3, 3);
    Plot1DPanel inputPanel = new Plot1DPanel(3, 0f, 1.0f, nn.inputs);
    Plot1DPanel hiddenPanel = new Plot1DPanel(3, 0f, 1.0f, nn.hidden);
    Plot1DPanel outputPanel = new Plot1DPanel(3, 0f, 1.0f, nn.outputs);
    Plot2DPanel w1Panel = new Plot2DPanel(3, 3, -1.0f, 1.0f, nn.W1);
    Plot2DPanel w2Panel = new Plot2DPanel(3, 3, -4.0f, 4.0f, nn.W2);
    JButton jButton1 = new JButton();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();

    public GUITest_1H() {
        try {
            nn.addTrainingExample(in1, out1);
            nn.addTrainingExample(in2, out2);
            nn.addTrainingExample(in3, out3);
            jbInit();
            this.setSize(450, 350);
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GUITest_1H GUITest_1H1 = new GUITest_1H();
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        inputPanel.setBounds(new Rectangle(5, 30, 400, 20));
        hiddenPanel.setBounds(new Rectangle(5, 138, 400, 20));
        outputPanel.setBounds(new Rectangle(5, 240, 400, 20));
        w1Panel.setBounds(new Rectangle(150, 50, 61, 61));
        w2Panel.setBounds(new Rectangle(150, 158, 61, 61));
        jButton1.setText("Reset and Run");
        jButton1.setBounds(new Rectangle(246, 290, 148, 28));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                try {
					do_run_button(e);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        this.setDefaultCloseOperation(3);
        jLabel1.setText("Input neurons:");
        jLabel1.setBounds(new Rectangle(4, 10, 144, 19));
        jLabel2.setText("Hidden neurons:");
        jLabel2.setBounds(new Rectangle(4, 115, 144, 19));
        jLabel3.setText("Output neurons:");
        jLabel3.setBounds(new Rectangle(4, 220, 240, 19));
        jLabel4.setText("input to hidden weights");
        jLabel4.setBounds(new Rectangle(220, 70, 150, 19));
        jLabel5.setText("hidden to output weights");
        jLabel5.setBounds(new Rectangle(220, 180, 190, 19));
        this.getContentPane().add(inputPanel, null);
        this.getContentPane().add(hiddenPanel, null);
        this.getContentPane().add(outputPanel, null);
        this.getContentPane().add(w1Panel, null);
        this.getContentPane().add(w2Panel, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().setBackground(Color.white);
    }

    void do_run_button(MouseEvent e) throws InterruptedException {
        Graphics g1 = inputPanel.getGraphics();
        Graphics g2 = hiddenPanel.getGraphics();
        Graphics g3 = outputPanel.getGraphics();
        Graphics g4 = w1Panel.getGraphics();
        Graphics g5 = w2Panel.getGraphics();
  training_loop:
        for (int i = 0; i < 5000; i++) {
        	if (i == 1000 || i == 3000 || i == 4000 | i ==4500)  nn.learningRate *= 0.75f;
            float error = nn.train();
            if (i > 0 && i % 500 == 0) {
            	//
            	// If the error is too large, slightly randomize weights:
            	if (error > 0.75)  {
            		nn.randomizeWeights();
            		nn.learningRate = 0.75f;
            	} else if (error > 0.3)  {
            		nn.slightlyRandomizeWeights();
            	}
            	System.out.println("cycle " + i + " error is " + error);
            	if (error < 0.1)  break training_loop;
            }
            inputPanel.paint(g1);
            hiddenPanel.paint(g2);
            outputPanel.paint(g3);
            w1Panel.paint(g4);
            w2Panel.paint(g5);
        }
        float [] answers;
        Thread.sleep(2000);
        answers = nn.recall(in1);
        for (int i=0; i<3; i++) nn.outputs[i] = answers[i];
        inputPanel.paint(g1);
        hiddenPanel.paint(g2);
        outputPanel.paint(g3);
        Thread.sleep(2000);
        answers = nn.recall(in2);
        for (int i=0; i<3; i++) nn.outputs[i] = answers[i];
        inputPanel.paint(g1);
        hiddenPanel.paint(g2);
        outputPanel.paint(g3);
        Thread.sleep(2000);
        answers = nn.recall(in3);
        for (int i=0; i<3; i++) nn.outputs[i] = answers[i];
        inputPanel.paint(g1);
        hiddenPanel.paint(g2);
        outputPanel.paint(g3);
        jButton1.setEnabled(true);
    }
}

package neuralnetworks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUITest_2H extends JFrame {
    static float[] in1 = {0.1f, 0.1f, 0.9f};
    static float[] in2 = {0.1f, 0.9f, 0.1f};
    static float[] in3 = {0.9f, 0.1f, 0.1f};

    static float[] out1 = {0.9f, 0.1f, 0.1f};
    static float[] out2 = {0.1f, 0.1f, 0.9f};
    static float[] out3 = {0.1f, 0.9f, 0.1f};

    static float[] test1 = {0.1f, 0.1f, 0.9f};
    static float[] test2 = {0.1f, 0.9f, 0.1f};
    static float[] test3 = {0.9f, 0.1f, 0.1f};

    Neural_2H nn = new Neural_2H(3, 3, 3, 3);
    Plot1DPanel inputPanel = new Plot1DPanel(3,   0.0f, 1.0f, nn.inputs);
    Plot1DPanel hidden1Panel = new Plot1DPanel(3, 0.0f, 1.0f, nn.hidden1);
    Plot1DPanel hidden2Panel = new Plot1DPanel(3, 0.0f, 1.0f, nn.hidden2);
    Plot1DPanel outputPanel = new Plot1DPanel(3,  0.0f, 1.0f, nn.outputs);
    Plot2DPanel w1Panel = new Plot2DPanel(3, 3, nn.clampWeight(-100), nn.clampWeight(100), nn.W1);
    Plot2DPanel w2Panel = new Plot2DPanel(3, 3, nn.clampWeight(-100), nn.clampWeight(100), nn.W2);
    Plot2DPanel w3Panel = new Plot2DPanel(3, 3, nn.clampWeight(-100), nn.clampWeight(100), nn.W3);
    JButton jButton1 = new JButton(); 
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel2b = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel4b = new JLabel();
    JLabel jLabel5 = new JLabel();

    public GUITest_2H() {
        try { 
            nn.addTrainingExample(in1, out1);
            nn.addTrainingExample(in2, out2);
            nn.addTrainingExample(in3, out3);
            jbInit();
            this.setSize(440, 450);
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	new GUITest_2H();
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        inputPanel.setBounds(new Rectangle(5, 30, 400, 20));
        hidden1Panel.setBounds(new Rectangle(5, 138, 400, 20));
        hidden2Panel.setBounds(new Rectangle(5, 238, 400, 20));
        outputPanel.setBounds(new Rectangle(5, 340, 400, 20));
        w1Panel.setBounds(new Rectangle(160, 50, 61, 61));
        w2Panel.setBounds(new Rectangle(160, 158, 61, 61));
        w3Panel.setBounds(new Rectangle(160, 258, 61, 61));
        jButton1.setText("Reset and Run");
        jButton1.setBounds(new Rectangle(246, 380, 148, 28));
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
        jLabel2.setText("Hidden 1 neurons:");
        jLabel2.setBounds(new Rectangle(4, 111, 144, 19));
        jLabel2b.setText("Hidden 2 neurons:");
        jLabel2b.setBounds(new Rectangle(4, 211, 144, 19));
        jLabel3.setText("Output neurons:");
        jLabel3.setBounds(new Rectangle(4, 317, 240, 19));
        jLabel4.setText("Input to H1 weights");
        jLabel4.setBounds(new Rectangle(230, 80, 170, 19));
        jLabel4b.setText("H1 to H2 weights");
        jLabel4b.setBounds(new Rectangle(230, 180, 170, 19));
        jLabel5.setText("H2 to output weights");
        jLabel5.setBounds(new Rectangle(230, 280, 170, 19));
        this.getContentPane().add(inputPanel, null);
        this.getContentPane().add(hidden1Panel, null);
        this.getContentPane().add(hidden2Panel, null);
        this.getContentPane().add(outputPanel, null);
        this.getContentPane().add(w1Panel, null);
        this.getContentPane().add(w2Panel, null);
        this.getContentPane().add(w3Panel, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel2b, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jLabel4b, null);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().setBackground(Color.white);
    }

    void do_run_button(MouseEvent e) throws InterruptedException {
    	jButton1.setEnabled(false);
        Graphics g1 = inputPanel.getGraphics();
        Graphics g2 = hidden1Panel.getGraphics();
        Graphics g3 = hidden2Panel.getGraphics();
        Graphics g4 = outputPanel.getGraphics();
        Graphics g5 = w1Panel.getGraphics();
        Graphics g6 = w2Panel.getGraphics();
        Graphics g7 = w3Panel.getGraphics();
  training_loop:
        for (int i = 0; i < 25000; i++) {
        	if (i == 5000 || i == 8000 || i == 10000 | i == 12000)  nn.TRAINING_RATE *= 0.75f;
            float error = nn.train();
            if (i > 0 && i % 500 == 0) {
            	//
            	// If the error is too large, slightly randomize weights:
            	if (error > 0.75)  {
            		nn.randomizeWeights();
            		nn.TRAINING_RATE = 0.75f;
            	} else if (error > 0.3)  {
            		nn.slightlyRandomizeWeights();
            	}
            	System.out.println("cycle " + i + " error is " + error);
            	if (error < 0.1)  break training_loop;
            }
            inputPanel.paint(g1);
            hidden1Panel.paint(g2);
            hidden2Panel.paint(g3);
            outputPanel.paint(g4);
            w1Panel.paint(g5);
            w2Panel.paint(g6);
            w3Panel.paint(g7);
        }
        float [] answers;
        Thread.sleep(2000);
        answers = nn.recall(in1);
        for (int i=0; i<3; i++) nn.outputs[i] = answers[i];
        inputPanel.paint(g1);
        hidden1Panel.paint(g2);
        hidden2Panel.paint(g3);
        outputPanel.paint(g4);
        Thread.sleep(2000);
        answers = nn.recall(in2);
        for (int i=0; i<3; i++) nn.outputs[i] = answers[i];
        inputPanel.paint(g1);
        hidden1Panel.paint(g2);
        hidden2Panel.paint(g3);
        outputPanel.paint(g4);
        Thread.sleep(2000);
        answers = nn.recall(in3);
        for (int i=0; i<3; i++) nn.outputs[i] = answers[i];
        inputPanel.paint(g1);
        hidden1Panel.paint(g2);
        hidden2Panel.paint(g3);
        outputPanel.paint(g4);
        jButton1.setEnabled(true);
        //nn.save("/tmp/neural_2h_save");
    }
}

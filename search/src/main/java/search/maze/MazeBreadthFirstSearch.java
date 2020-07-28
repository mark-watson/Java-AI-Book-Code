package search.maze;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 2D Maze Search: Performs a breadth first search in a maze
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
public class MazeBreadthFirstSearch extends javax.swing.JFrame {
    JPanel jPanel1 = new JPanel();
    BreadthFirstSearchEngine currentSearchEngine = null;

    public MazeBreadthFirstSearch() {
        try {
          jbInit();
        } catch (Exception e) {
          System.out.println("GUI initilization error: " + e);
        }
        currentSearchEngine = new BreadthFirstSearchEngine(10, 10);
        repaint();
    }

    public void paint(Graphics g_unused) {
        if (currentSearchEngine == null) return;
        Maze maze = currentSearchEngine.getMaze();
        int width = maze.getWidth();
        int height = maze.getHeight();
        System.out.println("Size of current maze: " + width + " by " + height);
        Graphics g = jPanel1.getGraphics();
        BufferedImage image = new BufferedImage(320, 320, BufferedImage.TYPE_INT_RGB);
        Graphics g2 = image.getGraphics();
        g2.setColor(Color.white);
        g2.fillRect(0, 0, 320, 320);
        g2.setColor(Color.black);
        maze.setValue(0, 0, Maze.START_LOC_VALUE);
        for (int x=0; x<width; x++) {
            for (int y=0; y<height; y++) {
                short val = maze.getValue(x,y);
                
                if ( val == Maze.OBSTICLE) {
                    g2.setColor(Color.lightGray);
                    g2.fillRect(6 + x * 29, 3 + y * 29, 29, 29);
                    g2.setColor(Color.black);
                	g2.drawRect(6 + x * 29, 3 + y * 29, 29, 29);
                } else if (val == Maze.START_LOC_VALUE) {
                    g2.setColor(Color.blue);
                    g2.drawString("S", 16 + x * 29, 19 + y * 29);
                    g2.setColor(Color.black);
                	g2.drawRect(6 + x * 29, 3 + y * 29, 29, 29);
                } else if (val == Maze.GOAL_LOC_VALUE) {
                    g2.setColor(Color.red);
                    g2.drawString("G", 16 + x * 29, 19 + y * 29);
                    g2.setColor(Color.black);
                	g2.drawRect(6 + x * 29, 3 + y * 29, 29, 29);
                } else {
                	g2.setColor(Color.black);
                	g2.drawRect(6 + x * 29, 3 + y * 29, 29, 29);
                }
            }
        }
        // redraw the path in black:
        g2.setColor(Color.black);
        Location [] path = currentSearchEngine.getPath();
        for (int i=1; i< (path.length-1); i++) {
          int x = path[i].x;
          int y = path[i].y;
          short val = maze.getValue(x,y);
          g2.drawString("" + (path.length - i), 16 + x * 29, 19 + y * 29);
        }
        g.drawImage(image, 30, 40, 320, 320, null);

    }

    public static void main(String[] args) {
        new MazeBreadthFirstSearch();
    }

    private void jbInit() throws Exception {

        this.setContentPane(jPanel1);
        this.setCursor(null);
        this.setDefaultCloseOperation(3);
        this.setTitle("MazeBreadthFirstSearch");
        this.getContentPane().setLayout(null);
        jPanel1.setBackground(Color.white);
        jPanel1.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
        jPanel1.setDoubleBuffered(false);
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(null);
        this.setSize(370, 420);
        this.setVisible(true);
    }
}



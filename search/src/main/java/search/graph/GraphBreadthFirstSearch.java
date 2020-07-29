package search.graph;

import javax.swing.*;
import java.awt.*;

public class GraphBreadthFirstSearch extends JFrame {
  JPanel jPanel1 = new JPanel();

  public GraphBreadthFirstSearch() {
    BreadthFirstSearch engine = new BreadthFirstSearch();
	  // Define a test network before calling the super class 'init':
	  engine.addNode("0", 20, 40);
	  engine.addNode("1", 60, 60);
	  engine.addNode("2", 100, 40);
	  engine.addNode("3", 50, 110);
	  engine.addNode("4", 140, 80);
	  engine.addNode("5", 160, 150);
	  engine.addNode("6", 200, 80);
	  engine.addNode("7", 160, 40);
	  engine.addNode("8", 240, 120);
	  engine.addNode("9", 260, 90);

	  engine.addLink(0,1);
	  engine.addLink(1,2);
	  engine.addLink(2,3);
	  engine.addLink(2,4);
	  engine.addLink(4,5);
	  engine.addLink(4,6);
	  engine.addLink(6,8);
	  engine.addLink(8,9);
	  engine.addLink(2,7);
	  engine.addLink(7,9);
          System.out.println("Before calculating path");
          path = engine.findPath(0, 9);
          System.out.println("After calculating path:");
          for (int i=0; i<path.length; i++) {
            System.out.println("  node # " + path[i]);
          }
          this.engine = engine;
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private int [] path = null;
  private BreadthFirstSearch engine = null;

  public static void main(String[] args) {
    GraphBreadthFirstSearch graphBreadthFirstSearch1 = new GraphBreadthFirstSearch();
  }

  private void jbInit() throws Exception {
    this.setDefaultCloseOperation(3);
    jPanel1.setBackground(Color.white);
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    this.setSize(290, 180);
    this.setVisible(true);
  }
    protected void paintNode(Graphics g, String name, int x, int y) {
	int len = name.length() * 10 + 6;
	int x1 = x - (len / 2);
	int x2 = x + (len / 2);
	int y1 = y - 10;
	int y2 = y + 10;
	g.setColor(Color.cyan);
	g.fill3DRect(x1, y1, len, 20, true);
	g.setColor(Color.black);
	g.drawString(name, x1 + 4, y2 - 6);
    }

    public void paint(Graphics g) {
	super.paint(g);
	if (engine != null && path != null) {
            int numNodes = engine.getNumNodes();
            int numLinks = engine.getNumLinks();
            for (int i=0; i<numLinks; i++) {
               int l1 = engine.getLink1(i);
               int l2 = engine.getLink2(i);
               int x1 = engine.getNodeX(l1);
               int y1 = engine.getNodeY(l1);
               int x2 = engine.getNodeX(l2);
               int y2 = engine.getNodeY(l2);
               g.setColor(Color.lightGray);
               g.drawLine(x1, y1, x2, y2);
            }
            for (int i=1; i<path.length; i++) {
               int x1 = engine.getNodeX(path[i-1]);
               int y1 = engine.getNodeY(path[i-1]);
               int x2 = engine.getNodeX(path[i]);
               int y2 = engine.getNodeY(path[i]);
               g.setColor(Color.black);
               g.drawLine(x1, y1, x2, y2);
            }
            for (int i=0; i<numNodes; i++) {
               int x1 = engine.getNodeX(i);
               int y1 = engine.getNodeY(i);
               paintNode(g, engine.getNodeName(i), x1, y1);
            }
        }
    }

}

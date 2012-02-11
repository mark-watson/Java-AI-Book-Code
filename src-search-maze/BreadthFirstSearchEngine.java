/**
 * Title:        BreadthFirstSearchEngine<p>
 * Description:  Performs a Breadth first search in a maze<p>
 * Copyright:    Copyright (c) Mark Watson, Released under Open Source Artistic License<p>
 * Company:      Mark Watson Associates<p>
 * @author Mark Watson
 * @version 1.0
 */

import java.awt.Dimension;

public class BreadthFirstSearchEngine extends AbstractSearchEngine {
    public BreadthFirstSearchEngine(int width, int height) {
        super(width, height);
        doSearchOn2DGrid();
    }

    private void doSearchOn2DGrid() {
        int width = maze.getWidth();
        int height = maze.getHeight();
        boolean alReadyVisitedFlag[][] = new boolean[width][height];
        //float distanceToNode[][] = new float[width][height];
        Dimension predecessor[][] = new Dimension[width][height];
        DimensionQueue queue = new DimensionQueue();

        for (int i=0; i<width; i++) {
            for (int j=0; j<height; j++) {
                alReadyVisitedFlag[i][j] = false;
                //distanceToNode[i][j] = 10000000.0f;
                predecessor[i][j] = null;
            }
        }

        alReadyVisitedFlag[startLoc.width][startLoc.height] = true;
        //distanceToNode[startLoc.width][startLoc.height] = 0.0f;
        queue.addToBackOfQueue(startLoc);
        boolean success = false;
    outer:      
        while (queue.isEmpty() == false) {
            Dimension head = queue.peekAtFrontOfQueue();
            if (head == null) break; // ??
            Dimension [] connected = getPossibleMoves(head);
            for (int i=0; i<4; i++) {
                if (connected[i] == null) break;
                int w = connected[i].width;
                int h = connected[i].height;
                if (alReadyVisitedFlag[w][h] == false) {
                    //distanceToNode[w][h] = distanceToNode[w][h] + 1.0f;
                    alReadyVisitedFlag[w][h] = true;
                    predecessor[w][h] = head;
                    queue.addToBackOfQueue(connected[i]);
                    if (equals(connected[i], goalLoc)) {
                        success = true;
                        break outer; // we are done
                    }
                }
            }
            queue.removeFromFrontOfQueue(); // ignore return value
        }
        // now calculate the shortest path from the predecessor array:
        maxDepth = 0;
        if (success) {
            searchPath[maxDepth++] = goalLoc;
            for (int i=0; i<100; i++) {
                searchPath[maxDepth] = predecessor[searchPath[maxDepth - 1].width][searchPath[maxDepth - 1].height];
                maxDepth++;
                if (equals(searchPath[maxDepth - 1], startLoc))  break;  // back to starting node
            }
        }
    }
    protected class DimensionQueue {
        public DimensionQueue(int num) {
            queue = new Dimension[num];
            head = tail = 0;
            len = num;
        }
        public DimensionQueue() {
            this(400);
        }
        public void addToBackOfQueue(Dimension n) {
            queue[tail] = n;
            if (tail >= (len - 1)) {
                tail = 0;
            } else {
                tail++;
            }
        }
        public Dimension removeFromFrontOfQueue() {
            Dimension ret = queue[head];
            if (head >= (len - 1)) {
                head = 0;
            } else {
                head++;
            }
            return ret;
        }
        public boolean isEmpty() {
            return head == (tail + 1);
        }
        public Dimension peekAtFrontOfQueue() {
            return queue[head];
        }       
        private Dimension [] queue;
        private int tail, head, len;
    }
}

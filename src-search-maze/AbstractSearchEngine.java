/**
 * Title:        AbstractSearchEngine<p>
 * Description:  Abstract search engine for searching paths in a maze<p>
 * Copyright:    Copyright (c) Mark Watson, Released under Open Source Artistic License<p>
 * Company:      Mark Watson Associates<p>
 * @author Mark Watson
 * @version 1.0
 */

import java.awt.Dimension;

public class AbstractSearchEngine {
    public AbstractSearchEngine(int width, int height) {
        maze = new Maze(width, height);
        initSearch();
    }
    public Maze getMaze() { return maze; }
    protected Maze maze;
    /**
     * We will use the Java type Dimension (fields width and height will
     * encode the coordinates in x and y directions) for the search path:
     */
    protected Dimension [] searchPath = null;
    protected int pathCount;
    protected int maxDepth;
    protected Dimension startLoc, goalLoc, currentLoc;
    protected boolean isSearching = true;

    protected void initSearch() {
        if (searchPath == null) {
            searchPath = new Dimension[1000];
            for (int i=0; i<1000; i++) {
                searchPath[i] = new Dimension();
            }
        }
        pathCount = 0;
        startLoc = maze.startLoc;
        currentLoc = startLoc;
        goalLoc = maze.goalLoc;
        searchPath[pathCount++] = currentLoc;
    }

    protected boolean equals(Dimension d1, Dimension d2) {
        return d1.getWidth() == d2.getWidth() && d1.getHeight() == d2.getHeight();
    }

    public Dimension [] getPath() {
      Dimension [] ret = new Dimension[maxDepth];
      for (int i=0; i<maxDepth; i++) {
        ret[i] = searchPath[i];
      }
      return ret;
    }
    protected Dimension [] getPossibleMoves(Dimension loc) {
        Dimension tempMoves [] = new Dimension[4];
        tempMoves[0] = tempMoves[1] = tempMoves[2] = tempMoves[3] = null;
        int x = loc.width;
        int y = loc.height;
        int num = 0;
        if (maze.getValue(x - 1, y) == 0 || maze.getValue(x - 1, y) == Maze.GOAL_LOC_VALUE) {
            tempMoves[num++] = new Dimension(x - 1, y);
        }
        if (maze.getValue(x + 1, y) == 0 || maze.getValue(x + 1, y) == Maze.GOAL_LOC_VALUE) {
            tempMoves[num++] = new Dimension(x + 1, y);
        }
        if (maze.getValue(x, y - 1) == 0 || maze.getValue(x, y - 1) == Maze.GOAL_LOC_VALUE) {
            tempMoves[num++] = new Dimension(x, y - 1);
        }
        if (maze.getValue(x, y + 1) == 0 || maze.getValue(x, y + 1) == Maze.GOAL_LOC_VALUE) {
            tempMoves[num++] = new Dimension(x, y + 1);
        }
        return tempMoves;
    }
}

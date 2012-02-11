/**
 * Title:        DepthFirstSearchEngine<p>
 * Description:  Performs a depth first search in a maze<p>
 * Copyright:    Copyright (c) Mark Watson, Released under Open Source Artistic License<p>
 * Company:      Mark Watson Associates<p>
 * @author Mark Watson
 * @version 1.0
 */

import java.awt.Dimension;

public class DepthFirstSearchEngine extends AbstractSearchEngine {
    public DepthFirstSearchEngine(int width, int height) {
        super(width, height);
        iterateSearch(startLoc, 1);
    }

    private void iterateSearch(Dimension loc, int depth) {
        if (isSearching == false) return;
        maze.setValue(loc.width, loc.height, (short)depth);
        Dimension [] moves = getPossibleMoves(loc);
        for (int i=0; i<4; i++) {
            if (moves[i] == null) break; // out of possible moves from this location
            searchPath[depth] = moves[i];
            if (equals(moves[i], goalLoc)) {
                System.out.println("Found the goal at " + moves[i].width +
                                   ", " + moves[i].height);
                isSearching = false;
                maxDepth = depth;
                return;
            } else {
                iterateSearch(moves[i], depth + 1);
                if (isSearching == false) return;
            }
        }
        return;
    }
}

package search.graph;

/**
 * Depth First Graph search
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
public class DepthFirstSearch extends AbstractGraphSearch {

    /** findPath - abstract method in super class */
    public int [] findPath(int start_node, int goal_node) { // return an array of node indices
        System.out.println("Entered DepthFirstSearch.findPath(" +
                           start_node + ", " + goal_node + ")");
        path[0] = start_node;
        return findPathHelper(path, 1, goal_node);
    }

    public int [] findPathHelper(int [] path, int num_path, int goal_node) {
        System.out.println("Entered DepthFirstSearch.findPathHelper(...," +
                           num_path + ", " + goal_node + ")");
        if (goal_node == path[num_path - 1]) {
            int [] ret = new int[num_path];
            for (int i=0; i<num_path; i++) ret[i] = path[i];
            return ret;  // we are done!
        }
        int [] new_nodes = connected_nodes(path, num_path);
        if (new_nodes != null) {
            for (int j=0; j<new_nodes.length; j++) {
                path[num_path] = new_nodes[j];
                int [] test = findPathHelper(path, num_path + 1, goal_node);
                if (test != null) {
                    if (test[test.length - 1] == goal_node) {
                        return test;
                    }
                }
            }
        }
        return null;
    }

    protected int [] connected_nodes(int [] path, int num_path) {
        // find all nodes connected to the last node on 'path'
        // that are not already on 'path'
        int [] ret = new int[AbstractGraphSearch.MAX];
        int num = 0;
        int last_node = path[num_path - 1];
        for (int n=0; n<numNodes; n++) {
            // see if node 'n' is already on 'path':
            boolean keep = true;
            for (int i=0; i<num_path; i++) {
                if (n == path[i]) {
                    keep = false;
                    break;
                }
            }
            boolean connected = false;
            if (keep) {
                // now see if there is a link between node 'last_node' and 'n':
                for (int i=0; i<numLinks; i++) {
                    if (link_1[i] == last_node) {
                        if (link_2[i] == n) {
                            connected = true;
                            break;
                        }
                    }
                    if (link_2[i] == last_node) {
                        if (link_1[i] == n) {
                            connected = true;
                            break;
                        }
                    }
                }
                if (connected) {
                    ret[num++] = n;
                }
            }
        }
        if (num == 0)  return null;
        int [] ret2 = new int[num];
        for (int i=0; i<num; i++) {
            ret2[i] = ret[i];
        }
        return ret2;
    }

}

package search.graph;

/**
 * Breadth First Graph search
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
public class BreadthFirstSearch extends AbstractGraphSearch {

    /** findPath - abstract method in super class */
    public int [] findPath(int start_node, int goal_node) { // return an array of node indices
	System.out.println("Entered BreadthFirstSearch.findPath(" +
			   start_node + ", " + goal_node + ")");
	// data structures for depth first search:
	boolean [] alreadyVisitedFlag = new boolean[numNodes];
	int [] predecessor = new int[numNodes];
	IntQueue queue = new IntQueue(numNodes + 2);

	for (int i=0; i<numNodes; i++) {
	    alreadyVisitedFlag[i] = false;
	    predecessor[i] = -1;
	}

	alreadyVisitedFlag[start_node] = true;
	queue.addToBackOfQueue(start_node);
outer:	while (queue.isEmpty() == false) {
	    int head = queue.peekAtFrontOfQueue();
	    int [] connected = connected_nodes(head);
	    if (connected != null) {
		for (int i=0; i<connected.length; i++) {
		    if (alreadyVisitedFlag[connected[i]] == false) {
			predecessor[connected[i]] = head;
			queue.addToBackOfQueue(connected[i]);
			if (connected[i] == goal_node) break outer; // we are done
		    }
		}
		alreadyVisitedFlag[head] = true;
		queue.removeFromQueue(); // ignore return value
	    }
	}
	// now calculate the shortest path from the predecessor array:
	int [] ret = new int[numNodes + 1];
	int count = 0;
	ret[count++] = goal_node;
	for (int i=0; i<numNodes; i++) {
	    ret[count] = predecessor[ret[count - 1]];
	    count++;
	    if (ret[count - 1] == start_node)  break;  // back to starting node
	}
	int [] ret2 = new int[count];
	for (int i=0; i<count; i++) {
	    ret2[i] = ret[count - 1 - i];
	}
	return ret2;
    }

    protected class IntQueue {
	public IntQueue(int num) {
	    queue = new int[num];
	    head = tail = 0;
	    len = num;
	}
	public IntQueue() {
	    this(400);
	}
	private int [] queue;
	int tail, head, len;
	public void addToBackOfQueue(int n) {
	    queue[tail] = n;
	    if (tail >= (len - 1)) {
		tail = 0;
	    } else {
		tail++;
	    }
	}
	public int removeFromQueue() {
	    int ret = queue[head];
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
	public int peekAtFrontOfQueue() {
	    return queue[head];
	}
    }

    protected int [] connected_nodes(int node) {
	int [] ret = new int[AbstractGraphSearch.MAX];
	int num = 0;

	for (int n=0; n<numNodes; n++) {
	    boolean connected = false;
	    // See if there is a link between node 'node' and 'n':
	    for (int i=0; i<numLinks; i++) {
		if (link_1[i] == node) {
		    if (link_2[i] == n) {
			connected = true;
			break;
		    }
		}
		if (link_2[i] == node) {
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
	if (num == 0)  return null;
	int [] ret2 = new int[num];
	for (int i=0; i<num; i++) {
	    ret2[i] = ret[i];
	}
	return ret2;
    }


}



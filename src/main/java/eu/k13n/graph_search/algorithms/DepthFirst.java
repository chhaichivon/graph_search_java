package eu.k13n.graph_search.algorithms;

import eu.k13n.graph_search.frontiers.Stack;
import eu.k13n.graph_search.shared.Node;
import eu.k13n.graph_search.shared.State;

public class DepthFirst extends GraphSearch {
	
	public DepthFirst(State state) {
		frontier = new Stack();
		frontier.add(new Node(state));
	}
}

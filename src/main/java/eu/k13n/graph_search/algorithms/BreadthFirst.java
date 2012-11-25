package eu.k13n.graph_search.algorithms;

import eu.k13n.graph_search.frontiers.Queue;
import eu.k13n.graph_search.shared.Node;
import eu.k13n.graph_search.shared.State;


public class BreadthFirst extends GraphSearch {

	public BreadthFirst(State state) {
		frontier = new Queue();
		frontier.add(new Node(state));
	}
}

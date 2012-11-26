package eu.k13n.graph_search.algorithms;

import java.util.Comparator;

import eu.k13n.graph_search.frontiers.PriorityQueue;
import eu.k13n.graph_search.shared.Heuristic;
import eu.k13n.graph_search.shared.Node;
import eu.k13n.graph_search.shared.State;

public class BestFirst extends GraphSearch {

	public BestFirst(State state, Comparator<Node> comparator) {
		frontier = new PriorityQueue(comparator);
		frontier.add(new Node(state));
	}
	
	public BestFirst(State state, final Heuristic heuristic) {
		this(state, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return heuristic.compute(o1.getState()) - heuristic.compute(o2.getState());
			}
		});
	}
}

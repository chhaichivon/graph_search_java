package eu.k13n.graph_search.algorithms;

import java.util.Comparator;

import eu.k13n.graph_search.frontiers.PriorityQueue;
import eu.k13n.graph_search.shared.Node;
import eu.k13n.graph_search.shared.State;

public class LowestCostFirst extends GraphSearch {
	
	public LowestCostFirst(State state, Comparator<Node> comparator) {
		frontier = new PriorityQueue(comparator);
		frontier.add(new Node(state));
	}
	
	public LowestCostFirst(State state) {
		this(state, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.getCost() - o2.getCost();
			}
		});
	}
}

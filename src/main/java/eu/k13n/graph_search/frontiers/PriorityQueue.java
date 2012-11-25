package eu.k13n.graph_search.frontiers;

import java.util.Comparator;

import eu.k13n.graph_search.shared.Node;

public class PriorityQueue implements Frontier {

	private java.util.PriorityQueue<Node> queue;
	
	public PriorityQueue(Comparator<Node> comparator) {
		queue = new java.util.PriorityQueue<>(100, comparator);
	}

	@Override
	public Node remove() {
		return queue.poll();
	}

	@Override
	public void add(Node node) {
		queue.add(node);
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

}

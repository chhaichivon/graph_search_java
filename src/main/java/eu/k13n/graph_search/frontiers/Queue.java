package eu.k13n.graph_search.frontiers;

import java.util.LinkedList;

import eu.k13n.graph_search.shared.Node;

public class Queue implements Frontier {
	private java.util.Queue<Node> queue;
	
	public Queue() {
		queue = new LinkedList<>();
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
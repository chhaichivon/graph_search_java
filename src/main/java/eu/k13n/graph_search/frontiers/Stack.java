package eu.k13n.graph_search.frontiers;

import eu.k13n.graph_search.shared.Node;

public class Stack implements Frontier {
	private java.util.Stack<Node> stack;
	
	public Stack() {
		this.stack = new java.util.Stack<>();
	}

	@Override
	public Node remove() {
		return stack.pop();
	}

	@Override
	public void add(Node node) {
		stack.push(node);
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}
}

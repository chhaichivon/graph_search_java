package eu.k13n.graph_search.algorithms;

import java.util.Stack;

import eu.k13n.graph_search.shared.Frontier;
import eu.k13n.graph_search.shared.Node;
import eu.k13n.graph_search.shared.State;

public class DepthFirst extends GraphSearch {

	private class FrontierStack implements Frontier {
		private Stack<Node> stack;
		
		public FrontierStack() {
			this.stack = new Stack<>();
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
	
	public DepthFirst(State state) {
		frontier = new FrontierStack();
		frontier.add(new Node(state));
	}
}

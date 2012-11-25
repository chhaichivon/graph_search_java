package eu.k13n.graph_search.algorithms;

import java.util.LinkedList;
import java.util.Queue;

import eu.k13n.graph_search.shared.Frontier;
import eu.k13n.graph_search.shared.Node;
import eu.k13n.graph_search.shared.State;


public class BreadthFirst extends GraphSearch {

	private class FrontierQueue implements Frontier {
		private Queue<Node> queue;
		
		public FrontierQueue() {
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
	
	public BreadthFirst(State state) {
		frontier = new FrontierQueue();
		frontier.add(new Node(state));
	}
}

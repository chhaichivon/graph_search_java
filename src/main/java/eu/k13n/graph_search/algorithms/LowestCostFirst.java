package eu.k13n.graph_search.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

import eu.k13n.graph_search.shared.Frontier;
import eu.k13n.graph_search.shared.Node;
import eu.k13n.graph_search.shared.State;

public class LowestCostFirst extends GraphSearch {

	private class FrontierQueue implements Frontier {
		private PriorityQueue<Node> queue;
		
		public FrontierQueue(Comparator<Node> comparator) {
			queue = new PriorityQueue<>(100, comparator);
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
	
	public LowestCostFirst(State state, Comparator<Node> comparator) {
		frontier = new FrontierQueue(comparator);
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

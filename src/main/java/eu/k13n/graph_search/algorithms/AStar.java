package eu.k13n.graph_search.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

import eu.k13n.graph_search.shared.Frontier;
import eu.k13n.graph_search.shared.Heuristic;
import eu.k13n.graph_search.shared.Node;
import eu.k13n.graph_search.shared.State;

public class AStar extends GraphSearch {

	private class FrontierPriorityQueue implements Frontier {
		private PriorityQueue<Node> queue;
		
		public FrontierPriorityQueue(Comparator<Node> comparator) {
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
	
	public AStar(State state, Comparator<Node> comparator) {
		frontier = new FrontierPriorityQueue(comparator);
		frontier.add(new Node(state));
	}
	
	public AStar(State state, final Heuristic heuristic) {
		this(state, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				int val1 = o1.getCost() + heuristic.compute(o1.getState());
				int val2 = o2.getCost() + heuristic.compute(o2.getState());
				return val1 - val2;
			}
		});
	}
}

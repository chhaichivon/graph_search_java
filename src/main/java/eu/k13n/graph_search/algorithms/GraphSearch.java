package eu.k13n.graph_search.algorithms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import eu.k13n.graph_search.shared.Frontier;
import eu.k13n.graph_search.shared.Node;
import eu.k13n.graph_search.shared.Path;
import eu.k13n.graph_search.shared.State;


public abstract class GraphSearch {
	public static boolean DEBUG = false;
	protected Frontier frontier;
	private Set<State> exploredStates;
	
	public GraphSearch() {
		exploredStates = new HashSet<>();
	}
	
	public Path search() {
		Node endNode = run();
		return Path.pathFromEndNode(endNode);
	}
	
	private final Node run() {
		int counter = 0;
		
		while (!frontier.isEmpty()) {
			Node node = frontier.remove();
			
			State state = node.getState();
			if (state.isGoal()) {
				return node;
			}
			exploredStates.add(state);
			
			counter++;
			if (DEBUG) System.out.println(counter);
			
			List<State> neighbors = state.getNeighbors();
			for (State neighbor : neighbors) {
				if (!exploredStates.contains(neighbor)) {
					Node nextNode = new Node(neighbor, node);
					frontier.add(nextNode);
				}
			}
		}
		return null;
	}
}

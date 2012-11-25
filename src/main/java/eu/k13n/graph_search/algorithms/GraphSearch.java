package eu.k13n.graph_search.algorithms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import eu.k13n.graph_search.shared.Frontier;
import eu.k13n.graph_search.shared.Node;
import eu.k13n.graph_search.shared.Path;
import eu.k13n.graph_search.shared.State;
import eu.k13n.graph_search.shared.StateChange;


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
			
			List<StateChange> stateChanges = state.getNeighbors();
			for (StateChange stateChange : stateChanges) {
				State followState = stateChange.getFollowState();
				if (!exploredStates.contains(stateChange.getFollowState())) {
					Node nextNode = new Node(followState, node);
					nextNode.setCost(node.getCost()+stateChange.getCost());
					frontier.add(nextNode);
				}
			}
		}
		return null;
	}
}

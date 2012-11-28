package eu.k13n.graph_search.algorithms;

import eu.k13n.graph_search.shared.Heuristic;
import eu.k13n.graph_search.shared.Node;
import eu.k13n.graph_search.shared.State;
import eu.k13n.graph_search.shared.StateChange;

public class IDAStar extends GraphSearch {
	private State initialState;
	private Heuristic heuristic;
	
	public IDAStar(State initialState, Heuristic heuristic) {
		this.initialState = initialState;
		this.heuristic = heuristic;
	}
	
	@Override
	protected Node run() {
		Node initialNode = new Node(initialState);
		Node solution = null;
		int currentCostBound = heuristic.compute(initialState);
		
		while (solution == null) {
			exploredStates.clear();
			exploredStates.add(initialState);
			solution = depthFirstSearch(initialNode, currentCostBound);
			currentCostBound += 2;
		}
		
		return solution;
	}
	
	private Node depthFirstSearch(Node currentNode, int currentCostBound) {
		State state = currentNode.getState();
		if (state.isGoal()) {
			return currentNode;
		}
		benchmark.increaseCycleCount();
		
		for (StateChange stateChange : state.getPossibleStateChanges()) {
			State followState = stateChange.getFollowState();
			int cost = currentNode.getCost() + stateChange.getCost();
			
			if (cost+heuristic.compute(followState) <= currentCostBound) {
				if (!cycleDetection || !exploredStates.contains(followState)) {
					Node nextNode = new Node(followState, currentNode);
					nextNode.setCost(cost);
					exploredStates.add(followState);
					
					Node possibleSolution = depthFirstSearch(nextNode, currentCostBound);
					if (possibleSolution != null) {
						return possibleSolution;
					}
				}
			}
		}
		return null;
	}
}

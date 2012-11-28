package eu.k13n.graph_search.algorithms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import eu.k13n.graph_search.frontiers.Frontier;
import eu.k13n.graph_search.shared.Benchmark;
import eu.k13n.graph_search.shared.Node;
import eu.k13n.graph_search.shared.Path;
import eu.k13n.graph_search.shared.State;
import eu.k13n.graph_search.shared.StateChange;


public abstract class GraphSearch {
	protected Frontier frontier;
	protected Set<State> exploredStates;
	protected Benchmark benchmark;
	protected boolean cycleDetection;
	
	public GraphSearch() {
		exploredStates = new HashSet<>();
		cycleDetection = true;
	}
	
	public Path search() {
		benchmark = new Benchmark();
		benchmark.startTimeMeasurement();
		Node endNode = run();
		benchmark.stopTimeMeasurement();
		return Path.constructFromEndNode(endNode);
	}
	
	protected Node run() {
		while (!frontier.isEmpty()) {
			Node node = frontier.remove();
			
			State state = node.getState();
			if (state.isGoal()) {
				return node;
			}
			if (cycleDetection) {
				exploredStates.add(state);
			}
			benchmark.increaseCycleCount();
			
			List<StateChange> stateChanges = state.getPossibleStateChanges();
			this.reorderStateChanges(stateChanges);
			for (StateChange stateChange : stateChanges) {
				State followState = stateChange.getFollowState();
				if (!cycleDetection || !exploredStates.contains(stateChange.getFollowState())) {
					Node nextNode = new Node(followState, node);
					nextNode.setCost(node.getCost()+stateChange.getCost());
					frontier.add(nextNode);
				}
			}
		}
		return null;
	}
	
	public void enableCycleDetection() {
		this.cycleDetection = true;
	}
	
	public void disableCycleDetection() {
		this.cycleDetection = false;
	}
	
	public Benchmark getBenchmark() {
		return benchmark;
	}
	
	protected void reorderStateChanges(List<StateChange> stateChanges) {}
}

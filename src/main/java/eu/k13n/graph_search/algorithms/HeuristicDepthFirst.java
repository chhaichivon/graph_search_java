package eu.k13n.graph_search.algorithms;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import eu.k13n.graph_search.shared.Heuristic;
import eu.k13n.graph_search.shared.State;
import eu.k13n.graph_search.shared.StateChange;

public class HeuristicDepthFirst extends DepthFirst {
	private Heuristic heuristic;
	
	public HeuristicDepthFirst(State state, Heuristic heuristic) {
		super(state);
		this.heuristic = heuristic;
	}
	
	@Override
	protected void reorderStateChanges(List<StateChange> stateChanges) {
		PriorityQueue<StateChange> changes = new PriorityQueue<>(stateChanges.size(), new Comparator<StateChange>() {
			@Override
			public int compare(StateChange o1, StateChange o2) {
				int val1 = heuristic.compute(o1.getFollowState());
				int val2 = heuristic.compute(o2.getFollowState());
				return val1 - val2;
			}
		});

		for (StateChange change : stateChanges) {
			changes.add(change);
		}
		stateChanges.clear();
		for (StateChange change : changes) {
			stateChanges.add(change);
		}
	}
}

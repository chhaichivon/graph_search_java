package eu.k13n.graph_search.shared;

import java.util.LinkedList;

public interface State {
	
	public LinkedList<StateChange> getNeighbors();
	public boolean isGoal();
}

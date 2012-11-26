package eu.k13n.graph_search.shared;

import java.util.LinkedList;

public interface State {
	
	public LinkedList<StateChange> getPossibleStateChanges();
	public boolean isGoal();

	// just to make it explicit, this three methods should be overwritten
	public boolean equals(Object obj);
	public int hashCode();
	public String toString();
}

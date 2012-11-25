package eu.k13n.graph_search.shared;

public interface Heuristic {
	
	public int compute(State currentState);
}

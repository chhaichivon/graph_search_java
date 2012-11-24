package eu.k13n.graph_search.shared;

public class Node {
	private Node parent;
	private State state;
	
	public Node(State state) {
		this.state = state;
	}
	
	public Node(State state, Node parent) {
		this.parent = parent;
		this.state = state;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public State getState() {
		return state;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}

	public void setState(State state) {
		this.state = state;
	}
}

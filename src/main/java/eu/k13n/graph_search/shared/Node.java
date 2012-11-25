package eu.k13n.graph_search.shared;

public class Node {
	private Node parent;
	private State state;
	private int cost;
	
	public Node(State state) {
		this.state = state;
	}
	
	public Node(State state, Node parent) {
		this.parent = parent;
		this.state = state;
	}
	
	public int getCost() {
		return cost;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public State getState() {
		return state;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Node) && ((Node)obj).state.equals(state);
	}
	
	@Override
	public int hashCode() {
		return state.hashCode();
	}
}

package eu.k13n.graph_search.shared;

public class StateChange {
	private State initialState, followState;
	private int cost;
	
	public StateChange(State initialState, State followState) {
		this.initialState = initialState;
		this.followState = followState;
	}
	
	public StateChange(State initialState, State followState, int cost) {
		this(initialState, followState);
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}
	
	public State getFollowState() {
		return followState;
	}
	
	public State getInitialState() {
		return initialState;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public void setFollowState(State followState) {
		this.followState = followState;
	}
	
	public void setInitialState(State initialState) {
		this.initialState = initialState;
	}
}

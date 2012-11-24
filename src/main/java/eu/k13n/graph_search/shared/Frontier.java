package eu.k13n.graph_search.shared;

public interface Frontier {
	
	public Node select();
	public void remove();
	public void add(Node node);
	public boolean isEmpty();

}

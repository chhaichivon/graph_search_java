package eu.k13n.graph_search.frontiers;

import eu.k13n.graph_search.shared.Node;

public interface Frontier {
	
	public Node remove();
	public void add(Node node);
	public boolean isEmpty();

}

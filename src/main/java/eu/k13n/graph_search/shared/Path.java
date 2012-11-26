package eu.k13n.graph_search.shared;

import java.util.LinkedList;
import java.util.List;

public class Path {
	LinkedList<Node> nodes;
	
	public Path() {
		this.nodes = new LinkedList<>();
	}
	
	public List<Node> getNodes() {
		return nodes;
	}
	
	public static Path constructFromEndNode(Node node) {
		Path path = new Path();
		while (node != null) {
			path.nodes.addFirst(node);
			node = node.getParent();
		}
		return path;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Node node : nodes) {
			s.append(node.getState());
			s.append("\n");
		}
		return s.toString();
	}
}

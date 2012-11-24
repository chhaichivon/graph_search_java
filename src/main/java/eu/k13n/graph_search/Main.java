package eu.k13n.graph_search;

import eu.k13n.graph_search.algorithms.BreadthFirst;
import eu.k13n.graph_search.problems.puzzle.PuzzleState;
import eu.k13n.graph_search.shared.Path;


public class Main {

	public static void main(String[] args) {
		PuzzleState initialState = PuzzleState.createRandomState(3);
		System.out.println("initial state: ");
		System.out.println(initialState);
		
		System.out.println();
		System.out.println("starting computation");
		
		BreadthFirst bfs = new BreadthFirst(initialState);
		Path path = bfs.search();
		
		System.out.println(path);
	}

}

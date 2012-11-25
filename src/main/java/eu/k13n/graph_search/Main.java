package eu.k13n.graph_search;

import eu.k13n.graph_search.algorithms.BreadthFirst;
import eu.k13n.graph_search.problems.puzzle.PuzzleState;
import eu.k13n.graph_search.shared.Path;

public class Main {

	public static void main(String[] args) {		
		PuzzleState initialState = PuzzleState.createRandomState(3);
		System.out.println();
		System.out.println("starting computation");
		
		long startTime = System.currentTimeMillis();
		BreadthFirst bfs = new BreadthFirst(initialState);
		Path path = bfs.search();
		long elapsedTIme = System.currentTimeMillis() - startTime;
		
		System.out.println("Initial State");
		System.out.println(initialState);
		System.out.println("Path");
		System.out.println(path);
		System.out.println("Path length: "+path.getNodes().size());
		System.out.println("Elapsed Time: "+(elapsedTIme)+" ms");
	}

}

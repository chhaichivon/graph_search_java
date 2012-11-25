package eu.k13n.graph_search;

import eu.k13n.graph_search.algorithms.AStar;
import eu.k13n.graph_search.algorithms.BreadthFirst;
import eu.k13n.graph_search.algorithms.DepthFirst;
import eu.k13n.graph_search.algorithms.LowestCostFirst;
import eu.k13n.graph_search.problems.puzzle.PuzzleState;
import eu.k13n.graph_search.problems.puzzle.heuristics.HammingDistance;
import eu.k13n.graph_search.shared.Path;

public class Main {

	public static void main(String[] args) {		
		PuzzleState initialState = PuzzleState.createRandomState(3);
		System.out.println();
		System.out.println("starting computation");
		
		BreadthFirst bfs = new BreadthFirst(initialState);
		DepthFirst dfs = new DepthFirst(initialState);
		LowestCostFirst lcfs = new LowestCostFirst(initialState);
		AStar astar = new AStar(initialState, new HammingDistance(PuzzleState.getGoalState(3)));
		
		long startTime = System.currentTimeMillis();
//		Path path = bfs.search();
//		Path path = dfs.search();
//		Path path = lcfs.search();
		Path path = astar.search();
		long elapsedTIme = System.currentTimeMillis() - startTime;
		
		System.out.println("Initial State");
		System.out.println(initialState);
		System.out.println("Path");
		System.out.println(path);
		System.out.println("Path length: "+path.getNodes().size());
		System.out.println("Elapsed Time: "+(elapsedTIme)+" ms");
	}

}

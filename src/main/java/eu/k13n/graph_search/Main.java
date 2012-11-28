package eu.k13n.graph_search;

import eu.k13n.graph_search.algorithms.*;
import eu.k13n.graph_search.problems.puzzle.*;
import eu.k13n.graph_search.problems.puzzle.heuristics.*;
import eu.k13n.graph_search.problems.towers_of_hanoi.*;
import eu.k13n.graph_search.shared.*;

public class Main {

	public static void main(String[] args) {
		State initialState;
//		initialState = new TowerState(9);
//		initialState = PuzzleState.createRandomState(3);
//		initialState = new PuzzleState(new byte[]{6, 0, 8, 7, 4, 5, 3, 1, 2});
//		initialState = PuzzleState.createRandomState(4);
		initialState = new PuzzleState(new byte[]{10, 11, 4, 7, 14, 3, 5, 12, 15, 8, 13, 6, 1, 0, 9, 2});
		
		Heuristic heuristic = null;
//		heuristic = new HammingDistance(PuzzleState.getGoalState(4));
		heuristic = new ManhattenDistance(PuzzleState.getGoalState(4));
		
		GraphSearch searchStrategy = null;
//		searchStrategy = new BreadthFirst(initialState);
//		searchStrategy = new DepthFirst(initialState);
//		searchStrategy = new LowestCostFirst(initialState);
//		searchStrategy = new BestFirst(initialState, heuristic);
//		searchStrategy = new HeuristicDepthFirst(initialState, heuristic);
//		searchStrategy = new AStar(initialState, heuristic);
		searchStrategy = new IDAStar(initialState, heuristic);
		
//		searchStrategy.disableCycleDetection();
		
		System.out.println("starting computation");
		Path path = searchStrategy.search();
		
		System.out.println("Initial State");
		System.out.println(initialState);
		System.out.println("Path");
		System.out.println(path);
		System.out.println("Nodes in path: "+path.getNodes().size());
		System.out.println(searchStrategy.getBenchmark());
	}

}

package eu.k13n.graph_search;

import eu.k13n.graph_search.algorithms.AStar;
import eu.k13n.graph_search.algorithms.BestFirst;
import eu.k13n.graph_search.algorithms.BreadthFirst;
import eu.k13n.graph_search.algorithms.DepthFirst;
import eu.k13n.graph_search.algorithms.GraphSearch;
import eu.k13n.graph_search.algorithms.HeuristicDepthFirst;
import eu.k13n.graph_search.algorithms.LowestCostFirst;
import eu.k13n.graph_search.problems.puzzle.PuzzleState;
import eu.k13n.graph_search.problems.puzzle.heuristics.HammingDistance;
import eu.k13n.graph_search.problems.puzzle.heuristics.ManhattenDistance;
import eu.k13n.graph_search.problems.towers_of_hanoi.TowerState;
import eu.k13n.graph_search.shared.Path;
import eu.k13n.graph_search.shared.State;

public class Main {

	public static void main(String[] args) {
		State initialState;
//		initialState = PuzzleState.createRandomState(3);
//		initialState = new PuzzleState(new byte[]{6, 0, 8, 7, 4, 5, 3, 1, 2});
		initialState = new TowerState(8);
		
		GraphSearch searchStrategy = null;
		searchStrategy = new BreadthFirst(initialState);
//		searchStrategy = new DepthFirst(initialState);
//		searchStrategy = new LowestCostFirst(initialState);
//		searchStrategy = new BestFirst(initialState, new HammingDistance(PuzzleState.getGoalState(3)));
//		searchStrategy = new BestFirst(initialState, new ManhattenDistance(PuzzleState.getGoalState(3)));
//		searchStrategy = new HeuristicDepthFirst(initialState, new HammingDistance(PuzzleState.getGoalState(3)));
//		searchStrategy = new HeuristicDepthFirst(initialState, new ManhattenDistance(PuzzleState.getGoalState(3)));
//		searchStrategy = new AStar(initialState, new HammingDistance(PuzzleState.getGoalState(3)));
//		searchStrategy = new AStar(initialState, new ManhattenDistance(PuzzleState.getGoalState(3)));
		
//		search.disableCycleDetection();
		
		System.out.println("starting computation");
		Path path = null;
		path = searchStrategy.search();
		
		System.out.println("Initial State");
		System.out.println(initialState);
		System.out.println("Path");
		System.out.println(path);
		System.out.println("Nodes in path: "+path.getNodes().size());
		System.out.println(searchStrategy.getBenchmark());
	}

}

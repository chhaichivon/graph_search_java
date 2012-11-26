package eu.k13n.graph_search;

import eu.k13n.graph_search.algorithms.AStar;
import eu.k13n.graph_search.algorithms.BestFirst;
import eu.k13n.graph_search.algorithms.BreadthFirst;
import eu.k13n.graph_search.algorithms.DepthFirst;
import eu.k13n.graph_search.algorithms.HeuristicDepthFirst;
import eu.k13n.graph_search.algorithms.LowestCostFirst;
import eu.k13n.graph_search.problems.puzzle.PuzzleState;
import eu.k13n.graph_search.problems.puzzle.heuristics.HammingDistance;
import eu.k13n.graph_search.problems.puzzle.heuristics.ManhattenDistance;
import eu.k13n.graph_search.shared.Path;

public class Main {

	public static void main(String[] args) {		
//		PuzzleState initialState = PuzzleState.createRandomState(3);
		PuzzleState initialState = new PuzzleState(new byte[]{6, 0, 8, 7, 4, 5, 3, 1, 2});
		System.out.println();
		System.out.println("starting computation");
		
		BreadthFirst bfs = new BreadthFirst(initialState);
		DepthFirst dfs = new DepthFirst(initialState);
		LowestCostFirst lcfs = new LowestCostFirst(initialState);
		BestFirst bestfs1 = new BestFirst(initialState, new HammingDistance(PuzzleState.getGoalState(3)));
		BestFirst bestfs2 = new BestFirst(initialState, new ManhattenDistance(PuzzleState.getGoalState(3)));
		HeuristicDepthFirst hdfs1 = new HeuristicDepthFirst(initialState, new HammingDistance(PuzzleState.getGoalState(3)));
		HeuristicDepthFirst hdfs2 = new HeuristicDepthFirst(initialState, new ManhattenDistance(PuzzleState.getGoalState(3)));
		AStar astar1 = new AStar(initialState, new HammingDistance(PuzzleState.getGoalState(3)));
		AStar astar2 = new AStar(initialState, new ManhattenDistance(PuzzleState.getGoalState(3)));
		
//		bfs.disableCycleDetection();
//		dfs.disableCycleDetection();
//		lcfs.disableCycleDetection();
//		bestfs1.disableCycleDetection();
//		bestfs2.disableCycleDetection();
//		hdfs1.disableCycleDetection();
//		hdfs2.disableCycleDetection();
//		astar1.disableCycleDetection();
//		astar2.disableCycleDetection();
		
		long startTime = System.currentTimeMillis();
		Path path = null;
//		path = bfs.search();
//		path = dfs.search();
//		path = lcfs.search();
//		path = bestfs1.search();
//		path = bestfs2.search();
//		path = hdfs1.search();
//		path = hdfs2.search();
//		path = astar1.search();
		path = astar2.search();
		long elapsedTIme = System.currentTimeMillis() - startTime;
		
		System.out.println("Initial State");
		System.out.println(initialState);
		System.out.println("Path");
		System.out.println(path);
		System.out.println("Path length: "+path.getNodes().size());
		System.out.println("Elapsed Time: "+(elapsedTIme)+" ms");
	}

}

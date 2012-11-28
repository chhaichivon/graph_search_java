package eu.k13n.graph_search;

import java.io.IOException;

import eu.k13n.graph_search.algorithms.*;
import eu.k13n.graph_search.problems.puzzle.*;
import eu.k13n.graph_search.problems.spellchecker.*;
import eu.k13n.graph_search.problems.towers_of_hanoi.*;
import eu.k13n.graph_search.shared.*;

public class Main {

	public static void main(String[] args) {
//		towersOfHanoi();
//		nPuzzle();
		spellChecker();
	}
	
	private static void towersOfHanoi() {
		State initialState = new TowerState(9);
		search(initialState, null);
	}
	
	private static void nPuzzle() {
		State initialState;
//		initialState = PuzzleState.createRandomState(3);
//		initialState = new PuzzleState(new byte[]{6, 0, 8, 7, 4, 5, 3, 1, 2});
//		initialState = PuzzleState.createRandomState(4);
		initialState = new PuzzleState(new byte[]{10, 11, 4, 7, 14, 3, 5, 12, 15, 8, 13, 6, 1, 0, 9, 2});
		
		Heuristic heuristic;
//		heuristic = new eu.k13n.graph_search.problems.puzzle.heuristics.HammingDistance(PuzzleState.getGoalState(4));
		heuristic = new eu.k13n.graph_search.problems.puzzle.heuristics.ManhattenDistance(PuzzleState.getGoalState(4));
		
		search(initialState, heuristic);
	}
	
	private static void spellChecker() {
		try {
			Dictionary.readFromFile("dictionary.txt");
		} catch (IOException e) {
			System.out.println("Dictionary could not be read");
			e.printStackTrace();
			System.exit(1);
		}
		
		State initialState;
		initialState = new WordState("dsfsd");
		
		Heuristic heuristic;
//		heuristic = new eu.k13n.graph_search.problems.spellchecker.heuristics.HammingDistance();
		heuristic = new eu.k13n.graph_search.problems.spellchecker.heuristics.LevenshteinDistance();
		
		search(initialState, heuristic);
	}
	
	private static void search(State initialState, Heuristic heuristic) {
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
		System.out.println();
		System.out.println("Initial State");
		System.out.println(initialState);
		System.out.println("Path");
		System.out.println(path);
		System.out.println("Nodes in path: "+path.getNodes().size());
		System.out.println(searchStrategy.getBenchmark());
	}

}

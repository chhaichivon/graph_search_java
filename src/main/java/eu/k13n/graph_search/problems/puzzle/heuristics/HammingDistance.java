package eu.k13n.graph_search.problems.puzzle.heuristics;

import eu.k13n.graph_search.problems.puzzle.PuzzleState;
import eu.k13n.graph_search.shared.Heuristic;
import eu.k13n.graph_search.shared.State;

public class HammingDistance implements Heuristic {
	private PuzzleState goalState;
	
	public HammingDistance(PuzzleState goalState) {
		this.goalState = goalState;
	}
	
	@Override
	public int compute(State currentState) {
		int errors = 0;
		byte[] goalCells = goalState.getCells();
		byte[] currentCells = ((PuzzleState) currentState).getCells();
		for (int i=0; i<goalCells.length; i++) {
			if (goalCells[i] != currentCells[i]) {
				errors += 1;
			}
		}
		
		return errors;
	}

}

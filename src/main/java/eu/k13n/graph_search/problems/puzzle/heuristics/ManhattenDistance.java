package eu.k13n.graph_search.problems.puzzle.heuristics;

import eu.k13n.graph_search.problems.puzzle.CellPosition;
import eu.k13n.graph_search.problems.puzzle.PuzzleState;
import eu.k13n.graph_search.shared.Heuristic;
import eu.k13n.graph_search.shared.State;

public class ManhattenDistance implements Heuristic {
	private PuzzleState goalState;
	private CellPosition position;
	private int dimension;
	
	public ManhattenDistance(PuzzleState goalState) {
		this.goalState = goalState;
		this.position = new CellPosition(0);
		this.dimension = goalState.getDimension();
	}
	
	@Override
	public int compute(State currentState) {
		int moves = 0;
		byte[] goalCells = goalState.getCells();
		byte[] currentCells = ((PuzzleState) currentState).getCells();
		
		for (int i=0; i<goalCells.length; i++) {
			position.setPosition(i);
			int row1 = position.getRowIndex(dimension);
			int col1 = position.getColIndex(dimension);
			
			position.setPosition(indexOf(goalCells, currentCells[i]));
			int row2 = position.getRowIndex(dimension);
			int col2 = position.getColIndex(dimension);
			
			moves += Math.abs(row2-row1);
			moves += Math.abs(col2-col1);
		}
		
		return moves;
	}
	
	private static int indexOf(byte[] cells, byte value) {
		for (int i=0; i<cells.length; i++) {
			if (cells[i] == value) return i;
		}
		throw new RuntimeException("Element can't be found in the array");
	}

}

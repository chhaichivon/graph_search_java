package eu.k13n.graph_search.problems.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import eu.k13n.graph_search.shared.State;


public class PuzzleState implements State {
	private static PuzzleState GOAL_3;
	private static PuzzleState GOAL_4;
	
	private byte[] cells;
	private int dimension;
	private int emptyPosition;
	
	public static PuzzleState getGoalState(int dimension) {
		if (dimension < 3 || dimension > 4) {
			throw new RuntimeException("Unsupported dimension");
		}
		
		if (dimension == 3) {
			if (GOAL_3 == null) {
				GOAL_3 = new PuzzleState(new byte[]{1,2,3,4,5,6,7,8,0});
			}
			return GOAL_3;
		} else {
			if (GOAL_4 == null) {
				GOAL_4 = new PuzzleState(new byte[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0});
			}
			return GOAL_4;
		}
	}
	
	public static PuzzleState createRandomState(int dimension) {
		int dimensions = dimension * dimension;
		PuzzleState state = new PuzzleState(dimension);
		ArrayList<Byte> list = new ArrayList<>(dimensions);
		for (byte i=0; i<dimensions; i++) list.add(i);
		Collections.shuffle(list);
		for (byte i=0; i<dimensions; i++) {
			byte cellValue = list.get(i);
			state.cells[i] = cellValue;
			if (cellValue == 0)  state.emptyPosition = i;
		}
		return state;
	}
	
	public PuzzleState(int dimension) {
		this.dimension = dimension;
		this.cells = new byte[dimension*dimension];
	}
	
	public PuzzleState(byte[] cells) {
		this.dimension = (int) Math.sqrt(cells.length);
		this.cells = new byte[cells.length];
		for (int i=0; i<cells.length; i++) {
			this.cells[i] = cells[i];
			if (cells[i] == 0) this.emptyPosition = i;
		}
	}
	
	@Override
	public boolean isGoal() {
		return getGoalState(dimension).equals(this);
	}
	
	@Override
	public LinkedList<State> getNeighbors() {
		LinkedList<State> neighbors = new LinkedList<>();
		
		CellPosition position = new CellPosition(emptyPosition);
		int row = position.getRowIndex(dimension);
		int col = position.getColIndex(dimension);
		
		if (CellPosition.validPosition(dimension, row+1, col)) {
			PuzzleState state = new PuzzleState(cells);
			state.swapEmpty(row+1, col);
			neighbors.add(state);
		}
		if (CellPosition.validPosition(dimension, row-1, col)) {
			PuzzleState state = new PuzzleState(cells);
			state.swapEmpty(row-1, col);
			neighbors.add(state);
		}
		if (CellPosition.validPosition(dimension, row, col+1)) {
			PuzzleState state = new PuzzleState(cells);
			state.swapEmpty(row, col+1);
			neighbors.add(state);
		}
		if (CellPosition.validPosition(dimension, row, col-1)) {
			PuzzleState state = new PuzzleState(cells);
			state.swapEmpty(row, col-1);
			neighbors.add(state);
		}
		return neighbors;
	}
	
	public CellPosition getEmptyPosition() {
		return new CellPosition(emptyPosition);
	}
	
	public byte[] getCells() {
		return cells;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof PuzzleState) && obj.hashCode() == this.hashCode();
	}
	
	@Override
	public int hashCode() {
		return Arrays.hashCode(cells);
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i=0; i<cells.length; i++) {
			byte cellValue = cells[i];
			if (cellValue < 10) builder.append(" ");
			builder.append(cellValue);
			builder.append("  ");
			if ((i+1) % dimension == 0) {
				builder.append("\n");
			}
		}
		return builder.toString();
	}
	
	private void swapEmpty(int row, int col) {
		int newEmptyPosition = row*dimension+col;
		cells[emptyPosition] = cells[newEmptyPosition]; 
		cells[row*dimension+col] = 0;
		emptyPosition = newEmptyPosition;
	}
}

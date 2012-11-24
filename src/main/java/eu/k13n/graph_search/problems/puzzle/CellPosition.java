package eu.k13n.graph_search.problems.puzzle;

public class CellPosition {
	private int absolutePosition;
	
	public CellPosition(int absolutePosition) {
		this.absolutePosition = absolutePosition;
	}
	
	public void setPosition(int position) {
		this.absolutePosition = position;
	}
	
	public int getAbsolutePosition() {
		return absolutePosition;
	}
	
	public int getRowIndex(int size) {
		return (int) absolutePosition / size;
	}
	
	public int getColIndex(int size) {
		return (int) absolutePosition % size;
	}
	
	public static boolean validPosition(int dimension, int row, int col) {
		return row >= 0 && row < dimension && col >= 0 && col < dimension;
	}
	
}

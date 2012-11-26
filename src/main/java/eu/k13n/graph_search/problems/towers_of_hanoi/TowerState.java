package eu.k13n.graph_search.problems.towers_of_hanoi;

import java.util.Arrays;
import java.util.LinkedList;

import eu.k13n.graph_search.shared.State;
import eu.k13n.graph_search.shared.StateChange;

public class TowerState implements State {
	private int[] peg1, peg2, peg3;
	private int dimension;
	
	public TowerState(int dimension) {
		this.dimension = dimension;
		this.peg1 = new int[dimension];
		this.peg2 = new int[dimension];
		this.peg3 = new int[dimension];
		for (int i=1; i<=dimension; i++) {
			peg1[i-1] = dimension-i+1;
		}
	}
	
	public TowerState(int[] peg1, int[] peg2, int[] peg3) {
		this.dimension = peg1.length;
		this.peg1 = new int[dimension];
		this.peg2 = new int[dimension];
		this.peg3 = new int[dimension];
		for (int i=0; i<dimension; i++) {
			this.peg1[i] = peg1[i];
			this.peg2[i] = peg2[i];
			this.peg3[i] = peg3[i];
		}
	}
	
	@Override
	public boolean isGoal() {
		return peg3[dimension-1] == 1;
	}
	
	@Override
	public LinkedList<StateChange> getPossibleStateChanges() {
		LinkedList<StateChange> stateChanges = new LinkedList<>();
		// peg 1
		int topDisk1 = getTopDisk(peg1);
		int topDisk2 = getTopDisk(peg2);
		int topDisk3 = getTopDisk(peg3);
		
		int topDiskPosition1 = getTopDiskPosition(peg1);
		int topDiskPosition2 = getTopDiskPosition(peg2);
		int topDiskPosition3 = getTopDiskPosition(peg3);
		
		if (topDisk1 > 0 && (topDisk1 < topDisk2 || topDisk2 == 0) && topDiskPosition2 < dimension-1) {
			TowerState state = new TowerState(peg1, peg2, peg3);
			state.moveTopDisk(state.peg1, state.peg2);
			stateChanges.add(new StateChange(this, state, 1));
		}
		if (topDisk1 > 0 && (topDisk1 < topDisk3 || topDisk3 == 0) && topDiskPosition3 < dimension-1) {
			TowerState state = new TowerState(peg1, peg2, peg3);
			state.moveTopDisk(state.peg1, state.peg3);
			stateChanges.add(new StateChange(this, state, 1));
		}
		if (topDisk2 > 0 && (topDisk2 < topDisk1 || topDisk1 == 0) && topDiskPosition1 < dimension-1) {
			TowerState state = new TowerState(peg1, peg2, peg3);
			state.moveTopDisk(state.peg2, state.peg1);
			stateChanges.add(new StateChange(this, state, 1));
		}
		if (topDisk2 > 0 && (topDisk2 < topDisk3 || topDisk3 == 0) && topDiskPosition3 < dimension-1) {
			TowerState state = new TowerState(peg1, peg2, peg3);
			state.moveTopDisk(state.peg2, state.peg3);
			stateChanges.add(new StateChange(this, state, 1));
		}
		if (topDisk3 > 0 && (topDisk3 < topDisk1 || topDisk1 == 0) && topDiskPosition1 < dimension-1) {
			TowerState state = new TowerState(peg1, peg2, peg3);
			state.moveTopDisk(state.peg3, state.peg1);
			stateChanges.add(new StateChange(this, state, 1));
		}
		if (topDisk3 > 0 && (topDisk3 < topDisk2 || topDisk2 == 0) && topDiskPosition2 < dimension-1) {
			TowerState state = new TowerState(peg1, peg2, peg3);
			state.moveTopDisk(state.peg3, state.peg2);
			stateChanges.add(new StateChange(this, state, 1));
		}
		return stateChanges;
	}
	
	private void moveTopDisk(int[] peg1, int[] peg2) {
		for (int i=dimension-1; i>=0; i--) {
			if (peg1[i] > 0) {
				for (int j=0; j<dimension; j++) {
					if (peg2[j] == 0) {
						int swap = peg1[i];
						peg1[i] = peg2[j];
						peg2[j] = swap;
						return;
					}
				}
			}
		}
	}
	
	private int getTopDisk(int[] peg) {
		int topDisk = 0;
		for (int i=0; i<dimension; i++) {
			if (peg[i] > 0) {
				topDisk = peg[i];
			}
		}
		return topDisk;
	}
	
	private int getTopDiskPosition(int[] peg) {
		int topDiskPosition = 0;
		for (int i=0; i<dimension; i++) {
			if (peg[i] > 0) {
				topDiskPosition = i;
			}
		}
		return topDiskPosition;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TowerState)) return false;
		TowerState state = (TowerState)obj;
		if (dimension != state.dimension) return false;
		for (int i=0; i<dimension; i++) {
			if (peg1[i] != state.peg1[i]) return false;
			if (peg2[i] != state.peg2[i]) return false;
			if (peg3[i] != state.peg3[i]) return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		// this hash function is pretty inefficient, anyone a suggestion for improvement?
		StringBuilder s = new StringBuilder();
		s.append(Arrays.hashCode(peg1));
		s.append(Arrays.hashCode(peg2));
		s.append(Arrays.hashCode(peg3));
		return s.toString().hashCode();
	}
	
	public void setPeg1(int[] peg1) {
		this.peg1 = peg1;
	}
	
	public void setPeg2(int[] peg2) {
		this.peg2 = peg2;
	}
	
	public void setPeg3(int[] peg3) {
		this.peg3 = peg3;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("peg1: ");
		for (int i=0; i<dimension; i++) {
			s.append(peg1[i]);
			s.append(" ");
		}
		s.append("\n");
		s.append("peg2: ");
		for (int i=0; i<dimension; i++) {
			s.append(peg2[i]);
			s.append(" ");
		}
		s.append("\n");
		s.append("peg3: ");
		for (int i=0; i<dimension; i++) {
			s.append(peg3[i]);
			s.append(" ");
		}
		s.append("\n");
		return s.toString();
	}
}

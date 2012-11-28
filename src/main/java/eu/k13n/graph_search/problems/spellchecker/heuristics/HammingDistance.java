package eu.k13n.graph_search.problems.spellchecker.heuristics;

import eu.k13n.graph_search.problems.spellchecker.Dictionary;
import eu.k13n.graph_search.problems.spellchecker.WordState;
import eu.k13n.graph_search.shared.Heuristic;
import eu.k13n.graph_search.shared.State;

public class HammingDistance implements Heuristic {

	@Override
	public int compute(State currentState) {
		WordState state = (WordState)currentState;
		int min = Integer.MAX_VALUE;
		for (String goal : Dictionary.WORDS) {
			int current = compute_single(state, goal);
			if (current<min) min = current;
		}
		return min;
	}
	
	private int compute_single(WordState state, String goal) {
		int errors = 0;
		for (int i=0; i<state.word.length && i<goal.length(); i++) {
			if (state.word[i] != goal.charAt(i)) {
				errors += 1;
			}
		}
		errors += Math.abs(goal.length()-state.word.length);
		return errors;
	}

}

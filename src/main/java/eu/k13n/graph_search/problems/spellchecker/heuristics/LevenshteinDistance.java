package eu.k13n.graph_search.problems.spellchecker.heuristics;

import eu.k13n.graph_search.problems.spellchecker.Dictionary;
import eu.k13n.graph_search.problems.spellchecker.WordState;
import eu.k13n.graph_search.shared.Heuristic;
import eu.k13n.graph_search.shared.State;

public class LevenshteinDistance implements Heuristic {

	@Override
	public int compute(State currentState) {
		WordState state = (WordState)currentState;
		int min = Integer.MAX_VALUE;
		for (String goal : Dictionary.WORDS) {
			int current = levenshtein(state.word, goal.toCharArray());
			if (current<min) min = current;
		}
		return min;
	}
	
	// recursive implementation of the Levenshtein distance
	public int levenshtein(char[] word, char[] goal) {
		if (word.length==0 || goal.length==0) {
			return Math.abs(word.length-goal.length);
		} 
		return levenshtein(word, goal, 0, 0);
	}
	
	public int levenshtein(char[] word, char[] goal, int pos1, int pos2) {
		if (pos1 < word.length && pos2 < goal.length) {
			int cost = (word[pos1] == goal[pos2]) ? 0 : 1;
			return cost + levenshtein(word, goal, pos1+1, pos2+1);
		} else {
			return Math.abs(word.length-goal.length);
		}
	}
}

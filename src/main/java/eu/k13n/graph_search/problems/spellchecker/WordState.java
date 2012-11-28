package eu.k13n.graph_search.problems.spellchecker;

import java.util.Arrays;
import java.util.LinkedList;

import eu.k13n.graph_search.shared.State;
import eu.k13n.graph_search.shared.StateChange;

public class WordState implements State {
	public final static char[] ALPHABET = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	public char[] word;

	public WordState(String word) {
		this.word = word.toCharArray();
	}
	
	public WordState(char[] word) {
		this.word = word;
	}
	
	@Override
	public LinkedList<StateChange> getPossibleStateChanges() {
		LinkedList<StateChange> changes = new LinkedList<>();
		
		// adding a letter
		for (char c : ALPHABET) {
			char[] out = append(this.word, c);
			State state = new WordState(out);
			StateChange change = new StateChange(this, state, 1);
			changes.add(change);
		}
		
		// deleting a letter
		for (int i=0; i<this.word.length; i++) {
			char[] out = delete(this.word, i);
			State state = new WordState(out);
			StateChange change = new StateChange(this, state, 1);
			changes.add(change);
		}
		
		// swapping a letter
		for (int i=0; i<this.word.length; i++) {
			for (char c : ALPHABET) {
				if (this.word[i] == c) continue;
				char[] out = swap(this.word, i, c);
				State state = new WordState(out);
				StateChange change = new StateChange(this, state, 1);
				changes.add(change);
			}
		}
		return changes;
	}
	
	private char[] append(char[] in, char c) {
		char[] out = new char[in.length+1];
		for (int i=0; i<in.length; i++) out[i] = in[i];
		out[in.length] = c;
		return out;
	}
	
	private char[] delete(char[] in, int position) {
		char[] out = new char[in.length-1];
		for (int i=0; i<position; i++) {
			out[i] = in[i];
		}
		for (int i=position+1; i<in.length; i++) {
			out[i-1] = in[i];
		}
		return out;
	}
	
	private char[] swap(char[] in, int position, char c) {
		char[] out = in.clone();
		out[position] = c;
		return out;
	}

	@Override
	public boolean isGoal() {
		String myWord = new String(this.word);
		for (String word : Dictionary.WORDS) {
			if (new String(myWord).equals(word)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return new String(this.word);
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof WordState) && obj.hashCode() == this.hashCode();
	}
	
	@Override
	public int hashCode() {
		return Arrays.hashCode(this.word);
	}
}

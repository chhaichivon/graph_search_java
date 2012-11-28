package eu.k13n.graph_search.problems.spellchecker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary {
	public static String[] WORDS = new String[0];
	
	public static void readFromFile(String filename) throws IOException {
		ArrayList<String> input = new ArrayList<>();
		
		String line = null;
		FileReader fr = new FileReader(new File(filename));
		BufferedReader br = new BufferedReader(fr);
		while ((line = br.readLine()) != null) {
			line = line.toLowerCase();
			input.add(line);
		}
		br.close();

		WORDS = input.toArray(new String[input.size()]);
	}
}

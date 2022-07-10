package ex01;

import java.io.*;
import java.util.*;

public class Words {
	public static void main(String[] args) {

		if (args.length < 2) {
			System.err.println("Not enough arguments");
			System.exit(1);
		}
		List<String> wordsList1;
		List<String> wordsList2;
		Set<String> dictionary;

		try {
			wordsList1 = retrieveWordsFromFile(args[0]);
			wordsList2 = retrieveWordsFromFile(args[1]);
			dictionary = retrieveDictionaryFromLists(wordsList1, wordsList2);
			writeDictionaryToFile(dictionary);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private static List<String> retrieveWordsFromFile(String fileName) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		List<String> wordsList = null;
		String line;
		String[] words;

		while ((line = file.readLine()) != null) {
			words = line.split(" ");
			wordsList = Arrays.asList(words);
		}
		file.close();
		return wordsList;
	}

	private static Set<String> retrieveDictionaryFromLists(List<String> wordsList1, List<String> wordsList2) {
		TreeSet<String> dictionary= new TreeSet<>();
		dictionary.addAll(wordsList1);
		dictionary.addAll(wordsList2);

		return dictionary;
	}

	private static void writeDictionaryToFile(Set<String> dictionarySet) throws IOException {
		BufferedWriter outFile = new BufferedWriter(new FileWriter("dictionary.txt"));

		for (String words : dictionarySet) {
			outFile.write(words + " ");
		}
		outFile.close();
	}
}

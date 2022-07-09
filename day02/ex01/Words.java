package ex01;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Words {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		try {
			BufferedReader file1 = new BufferedReader(new FileReader(scanner.next()));
			BufferedReader file2 = new BufferedReader(new FileReader(scanner.next()));
			BufferedWriter dictionaryFile = new BufferedWriter(new FileWriter("dictionary.txt"));
			List<String> fileDictionary1 = null;
			List<String> fileDictionary2 = null;
			Set<String> dictionary = null;
			String line;
			String[] arrayOfWords;

			while ((line = file1.readLine()) != null) {
				arrayOfWords = line.split(" ");
				fileDictionary1.addAll(Arrays.asList(arrayOfWords));
				dictionary.addAll(fileDictionary1);
			}

			while ((line = file2.readLine()) != null) {
				arrayOfWords = line.split(" ");
				fileDictionary2.addAll(Arrays.asList(arrayOfWords));
				dictionary.addAll(fileDictionary2);
			}

			for (String words : dictionary) {
				dictionaryFile.write(words + " ");
			}
			file1.close();
			file2.close();
			dictionaryFile.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}

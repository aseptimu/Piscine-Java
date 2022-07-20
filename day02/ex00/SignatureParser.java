package ex00;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SignatureParser {
	private static final String END = "42";
	private static final String RESULT = "/Users/aseptimu/IdeaProjects/Piscine/Piscine-Java/day02/ex00/result.txt";

	public Map<String, String> retrieveSignatures(File signature) throws FileNotFoundException {
		Map<String, String> signatures = new HashMap<>();
		StringBuilder str = new StringBuilder();
		FileInputStream fileInputStream = new FileInputStream(signature);
		int charRead;

		try {
			while ((charRead = fileInputStream.read()) != -1) {
				if ((char)charRead == '\n' || fileInputStream.available() == 0) {
					String[] format = str.toString().split(", ");
					signatures.put(format[1].trim(), format[0]);
					str.setLength(0);
					continue;
				}
				str.append((char)charRead);
			}
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return signatures;
	}

	public void retrieveFiles(Map<String, String> signatures) throws IOException {
		Scanner scanner = new Scanner(System.in);
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = new FileOutputStream(RESULT);
		StringBuilder builder = new StringBuilder();
		String input;

		while (!(input = scanner.nextLine()).equals(END)) {
			try {
				for (String key : signatures.keySet()) {
					fileInputStream = new FileInputStream(input);

					for (int i = 0; i < key.length(); i++) {
						builder.append(String.format("%02X ",fileInputStream.read()));
						if (key.startsWith(builder.toString())) {
							fileOutputStream.write(signatures.get(key).getBytes());
							fileOutputStream.write('\n');
							System.out.println("PROCESSED");
							break;
						}
					}
					builder.setLength(0);
				fileInputStream.close();
				}
			} catch (IOException e) {
				if (fileInputStream != null) {
					fileOutputStream.close();
				}
				scanner.close();
				fileOutputStream.close();
				e.printStackTrace();
				break;
			}
		}
		scanner.close();
		fileOutputStream.close();
	}


}

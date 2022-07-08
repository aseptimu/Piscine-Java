package ex00;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SignatureParser {
	private static final char COMA = ',';
	private static final String END = "42";
	private final FileInputStream fileInputStream;

	public SignatureParser(File signature) throws FileNotFoundException {
		this.fileInputStream = new FileInputStream(signature);
	}

	public Map<String, String> retrieveSignatures() {
		Map<String, String> signatures = new HashMap<>();
		StringBuilder str = new StringBuilder();
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
		} catch (IOException e) {
			e.printStackTrace();
		}

		return signatures;
	}


}

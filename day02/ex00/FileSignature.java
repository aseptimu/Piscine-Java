package ex00;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class FileSignature {

	private static final String SIGNATURES = "/Users/aseptimu/IdeaProjects/Piscine/Piscine-Java/day02/ex00/signatures.txt";

	public static void main(String[] args) throws IOException {
		SignatureParser signatureParser = new SignatureParser();
		Map<String, String> signatures = signatureParser.retrieveSignatures(new File(SIGNATURES));
		System.out.println(signatures.keySet());
		signatureParser.retrieveFiles(signatures);
	}
}

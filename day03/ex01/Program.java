package ex01;

public class Program {
	private final static String COUNT_FLAG = "--count=";

	public static void main(String[] args) {
		if (args.length != 1 || !args[0].startsWith(COUNT_FLAG)) {
			System.err.println("Wrong arguments");
			return ;
		}
		int count = Integer.parseInt(args[0].substring(COUNT_FLAG.length()));

	}
}

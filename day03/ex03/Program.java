package ex03;

public class Program {
	private static final String INPUT_FLAG = "--threadsCount=";

	public static void main(String[] args) {
		if (args.length != 1 && !args[0].startsWith(INPUT_FLAG)) {
			System.err.println("Wrong arguments");
			return ;
		}
		int threadsNumber = Integer.parseInt(args[0].substring(INPUT_FLAG.length()));
	}
}

package ex02;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {
	private static final String START_FLAG = "--current-folder=";

	public static void main(String[] args) {
		Path currentPath;

		if (args.length == 1 && args[0].startsWith(START_FLAG)) {
			currentPath = Paths.get(args[0].substring(START_FLAG.length()));
		} else {
			System.err.println("Wrong input");
			return ;
		}

		try {
			Commands commands = new Commands(currentPath);
			Scanner scanner = new Scanner(System.in);
			String line;
			String[] cmd;
			while (!(line = scanner.nextLine()).equals("exit")) {
				cmd = line.split(" ");
				switch (cmd[0]) {
					case "mv":
						commands.mv(Paths.get(cmd[1]), Paths.get(cmd[2]));
						break;
					case "ls":
						System.out.println("ls"); //TODO: delete
						break;
					case "cd":
						break;
					default:
						System.out.println("Wrong cmd");
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}

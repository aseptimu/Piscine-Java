package ex05;


public class Program {
	public static void main(String[] args) {
		Menu.Launch mode = Menu.Launch.Standard;
		if (args.length == 1 && args[0].equals("--profile=dev")) {
			mode = Menu.Launch.Dev;
		}
		Menu menu = new Menu(mode);
	}
}

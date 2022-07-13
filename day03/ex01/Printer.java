package ex01;

public class Printer implements Runnable {

	private final String message;
	private final int count;
	private static Printer print = null;

	public Printer(String message, int count) {
		this.message = message;
		this.count = count;
	}

	@Override
	public void run() {
		for (int i = 0; i < count;) {
			synchronized (Printer.class) {
				if (print != this) {
					print = this;
					System.out.println(message);
					i++;
				}
			}
		}
	}
}

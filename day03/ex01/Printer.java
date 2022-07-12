package ex01;

public class Printer implements Runnable {

	private final String message;
	private final int count;

	public Printer(String message, int count) {
		this.message = message;
		this.count = count;
	}

	@Override
	public void run() {
		System.out.println(message);
	}
}

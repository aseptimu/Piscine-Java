package ex00;

public class Program {
	public static void main(String[] args) {
		final int NUMBER = 479598;
		int sum = 0;

		sum += NUMBER % 10;
		sum += NUMBER % 100 / 10;
		sum += NUMBER % 1000 / 100;
		sum += NUMBER % 10000 / 1000;
		sum += NUMBER % 100000 / 10000;
		sum += NUMBER % 1000000 / 100000;

		System.out.println(sum);
	}
}

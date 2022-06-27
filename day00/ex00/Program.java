package ex00;

public class Program {
	public static void main(String[] args) {
		final int number = 479598;
		int sum = 0;

		sum += number % 10;
		sum += number % 100 / 10;
		sum += number % 1000 / 100;
		sum += number % 10000 / 1000;
		sum += number % 100000 / 10000;
		sum += number % 1000000 / 100000;

		System.out.println(sum);
	}
}

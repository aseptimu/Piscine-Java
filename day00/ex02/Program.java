package ex02;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final long stop = 42;
		int coffeeCount = 0;
		int input = scanner.nextInt();

		while (input != stop) {
			if (isPrimeNumber(sumOfDigits(input))) {
				coffeeCount++;
			}
			input = scanner.nextInt();
		}
		System.out.println("Count of coffee-request - " + coffeeCount);
	}

	private static int sumOfDigits(int number) {
		int sum = 0;

		while (number != 0) {
			sum += number % 10;
			number /= 10;
		}
		return (sum);
	}

	private static boolean isPrimeNumber(int number) {
		boolean isPrime;
		int check = 2;

		if (number < 2) {
			System.err.println("Illegal Argument");
			System.exit(-1);
		}
		while (check * check <= number && number % check != 0) {
			check++;
		}
		isPrime = check * check > number;
		return isPrime;
	}
}

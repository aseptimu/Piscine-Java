package ex01;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		int check = 2;
		boolean isPrime;

		if (number < 2) {
			System.err.println("Illegal Argument");
			System.exit(-1);
		}
		while (check * check <= number && number % check != 0) {
			check++;
		}
		isPrime = check * check > number;
		System.out.println(isPrime + " " + (check - 1));
	}
}

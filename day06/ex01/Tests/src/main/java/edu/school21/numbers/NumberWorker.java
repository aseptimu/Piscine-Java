package edu.school21.numbers;

public class NumberWorker {
	public boolean isPrime(int number) {
		int check = 2;
		boolean isPrime;

		if (number < 2) {
			throw new IllegalNumberException("number < 2");
		}
		while (check * check <= number && number % check != 0) {
			check++;
		}
		isPrime = check * check > number;
		return isPrime;
	}

	public int digitsSum(int number) {
		int sum = 0;

		while (number != 0) {
			sum += number % 10;
			number /= 10;
		}
		return (sum);
	}

	class IllegalNumberException extends RuntimeException {
		public IllegalNumberException(String message) {
			super (message);
		}
	}
}

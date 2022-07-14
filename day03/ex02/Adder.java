package ex02;

import java.util.Arrays;
import java.util.Random;

public class Adder {
	private static final String ARRAY_FLAG = "--arraySize=";
	private static final String THREAD_FLAG = "--threadsCount=";
	private static final int MAX_NUMBER_OF_ELEMENTS = 2000000;
	private static final int MAX_ELEMENT = 1000;

	private static void calculateSum(int[] array) {
		int sum = 0;

		for (int i : array) {
			sum += i;
		}
		System.out.println("Sum: " + sum);
	}

	public static void main(String[] args) {
		if (args.length != 2 || !args[0].startsWith(ARRAY_FLAG) ||
			!args[1].startsWith(THREAD_FLAG)) {
			System.err.println("Wrong arguments");
			return ;
		}
		int arraySize = Integer.parseInt(args[0].substring(ARRAY_FLAG.length()));
		int threadCount = Integer.parseInt(args[1].substring(THREAD_FLAG.length()));
		final int threadArraySize = arraySize / threadCount;
		int[] array = new int[arraySize];
		int sum = 0;
		Random generator = new Random();
		Threader[] threaders = new Threader[threadCount];

		if (arraySize > MAX_NUMBER_OF_ELEMENTS || threadCount > arraySize) {
			System.err.println("Wrong input");
			return ;
		}

		for (int i = 0; i < arraySize; i++) {
			array[i] = generator.nextInt(MAX_ELEMENT);
		}
		calculateSum(array);
		for (int i = 0; i < threadCount; i++) {
			int from = i * threadArraySize;
			int to = i != threadCount - 1 ? (i + 1) * threadArraySize : arraySize;
			threaders[i] = new Threader(Arrays.copyOfRange(array, from, to), i + 1, from, to);
		}
		for (Threader thread : threaders) {
			thread.start();
		}
		for (Threader thread : threaders) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (Threader thread : threaders) {
			sum += thread.getSum();
		}
		System.out.println("Sum by threads: " + sum);

	}
}

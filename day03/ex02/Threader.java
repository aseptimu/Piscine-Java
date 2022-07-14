package ex02;

public class Threader extends Thread {
	private final int[] subarray;
	private final int id;
	private final int from;
	private final int to;
	private int sum = 0;

	public Threader(int[] subarray, int id, int from, int to) {
		this.from = from;
		this.to = to;
		this.id = id;
		this.subarray = subarray;
	}

	@Override
	public void run() {
		for (int j : subarray) {
			sum += j;
		}
	}

	public int getSum() {
		printSum();
		return sum;
	}

	private void printSum() {
		System.out.println("Thread " + id + ": from " + from + " to " + to + " sum is " + sum);
	}
}

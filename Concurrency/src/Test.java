import java.util.Scanner;

public class Test implements Runnable {
	private volatile boolean interrupted = false;

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		while (System.currentTimeMillis() - startTime < 10000) {
			System.out.println("Still running");
		}
	}

	public void kill() {
		interrupted = true;
	}

	public static void main(String[] args) {
		Test test = new Test();
		Thread longThread = new Thread(test);
		longThread.start();

		// Detect input
		Scanner sc = new Scanner(System.in);
		while (true) {
			String input = sc.nextLine();
			input = input.trim().toLowerCase();

			if (input.equals("e")) {
				test.kill();
			}
		}
	}

}

import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
	public static Logger LOGGER;
	
	public static void main(String[] args) {
		initLogger(Level.INFO);
		
		int[] values = {3, 4, 7, 2, 1};
		int[] weights = {2, 1, 3, 1, 2};
		int maxWeight = 10;
		
		int answer = knapsack(values, weights, maxWeight);
		
		System.out.println("Max values in the bag: " + answer);
	}
	
	public static int knapsack(int[] V, int[] W, int w) {
		int itemCount = V.length;
		// int max = knapsackRecursive(V, W, itemCount - 1, w);
		int max = knapsackIterative(V, W, w);
		
		return max;
	}
	
	public static int knapsackIterative(int[] V, int[] W, int w) {
		int itemCount = V.length;
		int[][] M = new int[itemCount + 1][w + 1];
		
		for (int i = 1; i < itemCount + 1; i++) {
			for (int j = 0; j < w + 1; j++) {
				
				if (j < W[i - 1]) {
					M[i][j] = M[i - 1][j];
				} else {
					M[i][j] = Math.max(M[i - 1][j], M[i - 1][j - W[i - 1] ] + V[i - 1]);
				}
				
			}
		}
		
		// printArr(M);
		
		return M[itemCount][w];
	}
	
	public static void printArr(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				System.out.printf(A[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	// Return the max value with weight <= w using items up to i
	// Without memoisation
	public static int knapsackRecursive(int[] V, int[] W, int i, int w) {
		// Base cases
		if (i == 0) {
			if (W[i] <= w) {
				return V[i];
			} else {
				return 0;
			}
		}
		
		if (W[i] > w) {
			return 0;
		}
		
		// Two choices: take or don't take items at i, we take the max of the two choices
		int max = Math.max(
				knapsackRecursive(V, W, i - 1, w),
				knapsackRecursive(V, W, i - 1, w - W[i]) + V[i]);
		
		LOGGER.info(String.format("M[%d][%d] = %d%n", i , w, max));
		
		return max;
	}

	public static void initLogger(Level level) {
		LOGGER = Logger.getLogger(Main.class.getName());
		LOGGER.setLevel(level);
	}
}

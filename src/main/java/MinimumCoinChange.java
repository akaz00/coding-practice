import java.util.Arrays;

public class MinimumCoinChange {
	public static int[] NumberOfCoins(int[] coins, int sum) {
		int[] a = new int[sum + 1];
		Arrays.fill(a, Integer.MAX_VALUE - 1000);
		a[0] = 0;
		for (int i = 0; i <= sum; i++) {
			for (int j = coins.length - 1; j >= 0; j--) {
				if (coins[j] <= i) {
					a[i] = Math.min(1 + a[i - coins[j]], a[i]);
				}
			}
		}
		return a;
	}

	public static void main(String[] args) {
		int[] coins = new int[] { 1, 3, 5, 7 };
		int sum = 10;

		System.out.println(Arrays.toString(NumberOfCoins(coins, sum)));
	}
}

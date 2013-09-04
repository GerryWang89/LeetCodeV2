public class Solution {
    int[] prices;

    public int maxProfit(int[] prices) {
		this.prices = prices;
		if (prices.length < 4) {
			return maxProfit1(0, prices.length - 1);
		}
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			if (i + 1 < prices.length && prices[i] <= prices[i + 1] && max != 0)
				continue;
			int benefit = maxProfit1(0, i)
					+ maxProfit1(i + 1, prices.length - 1);
			if (benefit > max) {
				max = benefit;
			}
		}
		return max;
	}

	public int maxProfit1(int s, int e) {
		if (s >= e)
			return 0;
		int max = 0, base = Integer.MAX_VALUE;
		for (int i = s; i <= e; i++) {
			if (prices[i] < base) {
				base = prices[i];
			} else if (prices[i] > base) {
				if (prices[i] - base > max) {
					max = prices[i] - base;
				}
			}
		}
		return max;
	}
}
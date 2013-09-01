public class Solution {
    private int[] v;

    public int climbStairs(int n) {
		v = new int[n + 1];
		return getSteps(n);
	}

	private int getSteps(int n) {
		if (n <= 2)
			return n;
		if (v[n - 1] == 0)
			v[n - 1] = getSteps(n - 1);
		int last = v[n - 1];
		if (v[n - 2] == 0)
			v[n - 2] = getSteps(n - 2);
		int last2 = v[n - 2];
		return last + last2;
	}
}
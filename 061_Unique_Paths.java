public class Solution {
    private int[][] v;

    public int uniquePaths(int m, int n) {
		v = new int[m + 1][n + 1];
		return getPath(m, n);
	}

	private int getPath(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (m == 1 || n == 1) {
			return 1;
		}
		int left = 0;
		if (v[m][n - 1] == 0) {
			v[m][n - 1] = getPath(m, n - 1);
		}
		left = v[m][n - 1];
		int up = 0;
		if (v[m - 1][n] == 0) {
			v[m - 1][n] = getPath(m - 1, n);
		}
		up = v[m - 1][n];
		return left + up;
	}
}
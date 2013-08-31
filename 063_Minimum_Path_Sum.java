public class Solution {
    private int[][] v;

    public int minPathSum(int[][] grid) {
		int m = grid.length;
		if (m == 0) {
			return 0;
		}
		int n = grid[0].length;
		v = new int[m][n];
		return getMin(m, n, grid);
	}

	public int getMin(int m, int n, int[][] grid) {
		int ret = 0;
		if (m == 1) {
			for (int i = 0; i < n; i++) {
				ret += grid[0][i];
			}
			return ret;
		}
		if (n == 1) {
			for (int i = 0; i < m; i++) {
				ret += grid[i][0];
			}
			return ret;
		}
		int left = 0;
		if (v[m - 1][n - 2] == 0) {
			v[m - 1][n - 2] = getMin(m, n - 1, grid);
		}
		left = v[m - 1][n - 2];
		int up = 0;
		if (v[m - 2][n - 1] == 0) {
			v[m - 2][n - 1] = getMin(m - 1, n, grid);
		}
		up = v[m - 2][n - 1];
		return Math.min(left, up) + grid[m - 1][n - 1];
	}
}
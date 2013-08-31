public class Solution {
    private int[][] v;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0) {
			return 0;
		}
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if (obstacleGrid[m - 1][n - 1] == 1) {
			return 0;
		}
		v = new int[m + 1][n + 1];
		return getPath(m, n, obstacleGrid);
	}

	private int getPath(int m, int n, int[][] obstacleGrid) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (m == 1 || n == 1) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (obstacleGrid[i][j] == 1) {
						return 0;
					}
				}
			}
			return 1;
		}
		int left = 0;
		if (obstacleGrid[m - 1][n - 2] == 0) {
			if (v[m][n - 1] == 0) {
				v[m][n - 1] = getPath(m, n - 1, obstacleGrid);
			}
			left = v[m][n - 1];
		}
		int up = 0;
		if (obstacleGrid[m - 2][n - 1] == 0) {
			if (v[m - 1][n] == 0) {
				v[m - 1][n] = getPath(m - 1, n, obstacleGrid);
			}
			up = v[m - 1][n];
		}
		return left + up;
	}
}
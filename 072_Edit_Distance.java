public class Solution {
    public int minDistance(String word1, String word2) {
    	int[][] v;
		int m = word1.length() + 1;
		int n = word2.length() + 1;
		v = new int[m][n];
		for (int i = 0; i < m; i++) {
			v[i][0] = i;
		}
		for (int i = 0; i < n; i++) {
			v[0][i] = i;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					v[i][j] = v[i - 1][j - 1];
				} else {
					v[i][j] = v[i - 1][j - 1] + 1;
				}
				v[i][j] = Math.min(v[i][j],
						Math.min(v[i - 1][j] + 1, v[i][j - 1] + 1));
			}
		}
		return v[m - 1][n - 1];
	}
}
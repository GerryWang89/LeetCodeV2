public class Solution {
    private boolean[][] isPalin;
	private boolean[] isVisited;

	public int minCut(String s) {
		if (s.length() == 0)
			return 0;
		int cut = 0;
		initIsPalin(s);
		isVisited = new boolean[s.length()];
		isVisited[0] = true;
		Queue<Integer> cur;
		Queue<Integer> pre = new LinkedList<Integer>();
		pre.offer(0);
		while (!pre.isEmpty()) {
			cur = new LinkedList<Integer>();
			while (!pre.isEmpty()) {
				int node = pre.poll();
				if (isPalin[node][s.length() - 1])
					return cut;
				for (int i = node; i < s.length(); i++) {
					if (isPalin[node][i] && !isVisited[i + 1]){
						cur.offer(i + 1);
						isVisited[i + 1] = true;
					}
				}
			}
			pre = cur;
			cut++;
		}
		return -1;
	}

	private void initIsPalin(String s) {
		int n = s.length();
		isPalin = new boolean[n][n];
		for (int i = 0; i < n; i++)
			isPalin[i][i] = true;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n && j + i < n; j++) {
				int x = j, y = j + i;
				if (x + 1 == y)
					isPalin[x][y] = s.charAt(x) == s.charAt(y);
				else {
					isPalin[x][y] = (s.charAt(x) == s.charAt(y))
							&& isPalin[x + 1][y - 1];
				}
			}
		}
	}
}
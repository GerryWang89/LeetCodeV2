public class Solution {
    private int m, n;

    public void solve(char[][] board) {
		if (board.length < 3) {
			return;
		}
		if (board[0].length < 3) {
			return;
		}
		m = board.length;
		n = board[0].length;
		int[][] v = new int[m][n];
		Queue<BoardPoint> queue = new LinkedList<BoardPoint>();
		for (int i = 1; i < board[0].length - 1; i++) {
			if (board[0][i] == 'O') {
				queue.offer(new BoardPoint(0, i));
				v[0][i] = 1;
			}
			if (board[board.length - 1][i] == 'O') {
				queue.offer(new BoardPoint(board.length - 1, i));
				v[board.length - 1][i] = 1;
			}
		}
		for (int i = 1; i < board.length - 1; i++) {
			if (board[i][0] == 'O') {
				queue.offer(new BoardPoint(i, 0));
				v[i][0] = 1;
			}
			if (board[i][board[0].length - 1] == 'O') {
				queue.offer(new BoardPoint(i, board[0].length - 1));
				v[i][board[0].length - 1] = 1;
			}
		}
		while (!queue.isEmpty()) {
			BoardPoint p = queue.poll();
			if(isIn(p.x - 1, p.y) && board[p.x - 1][p.y] == 'O' && v[p.x-1][p.y] != 1){
				v[p.x-1][p.y] = 1;
				queue.offer(new BoardPoint(p.x-1, p.y));
			}
			if(isIn(p.x + 1, p.y) && board[p.x + 1][p.y] == 'O' && v[p.x+1][p.y] != 1){
				v[p.x+1][p.y] = 1;
				queue.offer(new BoardPoint(p.x+1, p.y));
			}
			
			if(isIn(p.x, p.y - 1) && board[p.x][p.y - 1] == 'O' && v[p.x][p.y-1] != 1){
				v[p.x][p.y - 1] = 1;
				queue.offer(new BoardPoint(p.x, p.y-1));
			}
			if(isIn(p.x, p.y + 1) && board[p.x][p.y + 1] == 'O' && v[p.x][p.y+1] != 1){
				v[p.x][p.y + 1] = 1;
				queue.offer(new BoardPoint(p.x, p.y+1));
			}
		}
		for(int i = 1; i < board.length - 1; i++){
			for(int j = 1; j < board[0].length - 1; j++){
				if(board[i][j] == 'O' && v[i][j] == 0){
					board[i][j] = 'X';
				}
			}
		}
	}

	private boolean isIn(int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}

	public class BoardPoint {
		public int x;
		public int y;

		public BoardPoint(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
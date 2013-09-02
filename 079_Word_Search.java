public class Solution {
    private int[][] visited;
    
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = 1;
                    if (solve(board, i, j, word, 1))
                        return true;
                    visited[i][j] = 0;
                }
            }
        }
        return false;
    }
    
    public boolean solve(char[][] board, int r, int c, String word, int index){
        if (index == word.length()) 
            return true;
        if (r - 1 >= 0 && visited[r - 1][c] == 0 && board[r - 1][c] == word.charAt(index)) {
            visited[r - 1][c] = 1;
            if (solve(board, r - 1, c, word, index + 1))
                return true;
            visited[r - 1][c] = 0;
        }
        if (r + 1 < board.length && visited[r + 1][c] == 0 && board[r + 1][c] == word.charAt(index)) {
            visited[r + 1][c] = 1;
            if (solve(board, r + 1, c, word, index + 1))
                return true;
            visited[r + 1][c] = 0;
        }
        if (c - 1 >= 0 && visited[r][c - 1] == 0 && board[r][c - 1] == word.charAt(index)) {
            visited[r][c - 1] = 1;
            if (solve(board, r, c - 1, word, index + 1))
                return true;
            visited[r][c - 1] = 0;
        }
        if (c + 1 < board[0].length && visited[r][c + 1] == 0 && board[r][c + 1] == word.charAt(index)) {
            visited[r][c + 1] = 1;
            if (solve(board, r, c + 1, word, index + 1))
                return true;
            visited[r][c + 1] = 0;
        }
        return false;
    }
}
public class Solution {
    private int[][] valid;
    
    public void solveSudoku(char[][] board) {
        valid = new int[27][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char ch = board[i][j];
                    valid[i][ch - '1'] = 1;
                    valid[9 + j][ch - '1'] = 1;
                    valid[18 + i / 3 + j / 3 * 3][ch - '1'] = 1;
                }
            }
        }
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.'){
                    for (int k = 0; k < 9; k++) {
                        char ch = (char)('1' + k);
                        if (isValid(i, j, ch)) {
                            valid[i][ch - '1'] = 1;
                            valid[9 + j][ch - '1'] = 1;
                            valid[18 + i / 3 + j / 3 * 3][ch - '1'] = 1;
                            board[i][j] = ch;
                            if (solve(board))
                                return true;
                            valid[i][ch - '1'] = 0;
                            valid[9 + j][ch - '1'] = 0;
                            valid[18 + i / 3 + j / 3 * 3][ch - '1'] = 0;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(int i, int j, char val){
        return valid[i][val - '1'] == 0 
               && valid[9 + j][val - '1'] == 0
               && valid[18 + i / 3 + j / 3 * 3][val - '1'] == 0;
    }
}
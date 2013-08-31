public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //0~8 horizon  9~17 vertical 18~26 rectangle
        int[][] valid = new int[27][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') 
                    continue;
                char ch = board[i][j];
                //horizon
                if (valid[i][ch - '1'] == 1)
                    return false;
                else                  
                    valid[i][ch - '1'] = 1;
                //vertical
                if (valid[9 + j][ch - '1'] == 1)
                    return false;
                else                  
                    valid[9 + j][ch - '1'] = 1;
                //rectangle
                if (valid[18 + i / 3 + j / 3 * 3][ch - '1'] == 1)
                    return false;
                else                  
                    valid[18 + i / 3 + j / 3 * 3][ch - '1'] = 1;
            }
        }
        return true;
    }
}
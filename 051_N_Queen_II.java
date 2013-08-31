public class Solution {
    private int[] x;
    private int ret;
    
    public int totalNQueens(int n) {
        x = new int[n];
        ret = 0;
        solve(0, n);
        return ret;
    }
    
    private void solve(int row, int n){
        if(row == n){
            ret++;
            return;
        }            
        for (int i = 0; i < n; i++) {
            if (isValid(i, row)) {
                x[row] = i;
                solve(row + 1, n);
            }
        }
    }
    
    private boolean isValid(int line, int row){
        for(int i = 0; i < row; i++){
    		if(Math.abs(line-x[i]) == Math.abs(row-i) || x[i] == line){
    			return false;
    		}
    	}
    	return true;
    }
}
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        if(n == 0){
            return ret;
        }
        int sum = 1;
        int i = 0, j = 0;
        while(sum <= n*n){
            while( i >= 0 && i < n && j >= 0 && j < n && ret[i][j] == 0){
                ret[i][j] = sum;
                j++;
                sum++;
            }
            j--;
            i++;
            while(i >= 0 && i < n && j >= 0 && j < n && ret[i][j] == 0){
                ret[i][j] = sum;
                i++;
                sum++;
            }
            i--;
            j--;
            while(i >= 0 && i < n && j >= 0 && j < n && ret[i][j] == 0){
                ret[i][j] = sum;
                j--;
                sum++;
            }
            j++;
            i--;
            while(i >= 0 && i < n && j >= 0 && j < n && ret[i][j] == 0){
                ret[i][j] = sum;
                i--;
                sum++;
            }
            i++;
            j++;
        }
        return ret;
    }
}
public class Solution {
    public final int RIGHT = 0;//j++
    public final int DOWN = 1;//i++
    public final int LEFT = 2;//j--
    public final int UP = 3;//i--
    
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(matrix.length == 0 ||matrix[0].length == 0)
            return ret;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] isRead = new int[m][n];
        int i = 0, j = 0;
        int state = -1;
        while(ret.size() < m*n){
            state = (state+1)%4;
            while(i < m && i >= 0 && j >= 0 && j < n && isRead[i][j] == 0){
                ret.add(matrix[i][j]);
                isRead[i][j] = 1;
                switch(state){
                case RIGHT:                    
                    j++;
                    break;
                case DOWN:
                    i++;
                    break;
                case LEFT:
                    j--;
                    break;
                case UP:
                    i--;
                    break;
                }
            }
            switch(state){
            case RIGHT:                    
                j--;
                i++;
                break;
            case DOWN:
                i--;
                j--;
                break;
            case LEFT:
                j++;
                i--;
                break;
            case UP:
                i++;
                j++;
                break;
            }
        }
        return ret;
    }
}
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target) {
                return bs(matrix[i], target);
            }
        }
        return false;
    }
    
    private boolean bs(int[] num, int target){
        int left = 0, right = num.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (num[mid] > target) {
                right = mid - 1;
            } else if (num[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
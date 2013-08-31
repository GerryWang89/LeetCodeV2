public class Solution {
    public boolean canJump(int[] A) {
        int max = 0;
        for (int i = 0; i <= max; i++) {
            max = Math.max(max, i + A[i]);
            if (max >= A.length - 1)
                return true;
        }
        return false;
    }
}
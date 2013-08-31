public class Solution {
    public int trap(int[] A) {
        if(A.length <= 2)
            return 0;
        int ret = 0;
        int[] hLeft = new int[A.length+2];
        int[] hRight = new int[A.length+2];
        for (int i = 1; i < hLeft.length - 1; i++) {
            hLeft[i] = Math.max(hLeft[i - 1], A[i - 1]);
        }
        for (int i = hRight.length - 2; i >= 1; i--) {
            hRight[i] = Math.max(hRight[i + 1], A[i - 1]);
        }
        for (int i = 1; i < hLeft.length - 1; i++) {
            ret += Math.max(0, Math.min(hLeft[i], hRight[i]) - A[i - 1]);
        }
        return ret;
    }
}
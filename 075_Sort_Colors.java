public class Solution {
    public void sortColors(int[] A) {
        int[] count = new int[3];
        for (int i = 0; i < A.length; i++)
            count[A[i]]++;
        count[1] = count[0] + count[1];
        count[2] = count[1] + count[2];
        int cur = 0;
        for (int i = 0; i < A.length; i++) {
            while (i == count[cur]) 
                cur++;
            A[i] = cur;
        }
    }
}
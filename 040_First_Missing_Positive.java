public class Solution {
    public int firstMissingPositive(int[] A) {
        for(int i = 0; i < A.length; i++){
            if(A[i] <= 0){
                A[i] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < A.length; i++){
            if(Math.abs(A[i])-1 < A.length && A[Math.abs(A[i])-1] > 0)
                A[Math.abs(A[i])-1] *= -1;
        }
        for(int i = 0; i < A.length; i++){
            if(A[i] > 0)
                return i+1;
        }
        return A.length+1;
    }
}
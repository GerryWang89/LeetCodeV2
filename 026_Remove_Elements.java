public class Solution {
    public int removeElement(int[] A, int elem) {
        int n = A.length;
        for(int i = A.length - 1; i >= 0; i--){
            if(A[i] == elem){
                A[i] = A[--n];
            }
        }
        return n;
    }
}
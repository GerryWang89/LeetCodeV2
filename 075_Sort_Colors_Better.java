public class Solution {
    public void sortColors(int[] A) {
        int p = 0, q = A.length - 1;
        for (int i = 0; i <= q && p < q; i++) {
            if (A[i] == 0){
            	while(p < i && A[p] == 0)
            		p++;
        		if (p == i){
            		p++;
            		continue;
            	}
                swap(A, p++, i--);
            }
            else if (A[i] == 2){
            	while(q > i && A[q] == 2)
            		q--;
                swap(A, q--, i--);
            }
        }
    }
    
    private void swap(int[] A, int i, int j){
        if (i == j)
    		return;
        A[i] = A[i] ^ A[j];
        A[j] = A[i] ^ A[j];
        A[i] = A[i] ^ A[j];
    }
}
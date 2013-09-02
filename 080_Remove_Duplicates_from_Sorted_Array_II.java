public class Solution {
    public int removeDuplicates(int[] A) {
        List<Integer> iList = new ArrayList<Integer>();
        if (A.length == 1) {
            return 1;
        }
        int ret = 0;
        int i = 0, j = 0;
        while( i < A.length ){
            for (j = i; j < A.length && A[i] == A[j]; j++) {
                if (j - i < 2) {
                    iList.add(A[j]);
                }
            }
            if(j - i >= 2){
                ret += 2;
            }else{
                ret += j - i;
            }
            i = j;
        }
        for(i = 0; i < iList.size(); i++){
            A[i] = iList.get(i);
        }
        return ret;
    }
}
public class Solution {
    private int step;
    
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        step = 0;
        if(A.length == 1){
            return 0;
        }
        return getMax(A,0,0);
    }
    
    public int getMax(int[] A, int index, int farthest){
        step++;
        int max = 0;
        for(int i = index; i <= farthest; i++){
            if(i+A[i] > max){
                max = i+A[i];
                if(max >= A.length-1)
                    return step;
            }
        }
        return getMax(A,farthest+1,max);
    }
}
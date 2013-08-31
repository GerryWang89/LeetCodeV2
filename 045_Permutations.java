public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        while (true) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            for(int i : num)
                cur.add(i);
            ret.add(cur);
            if(!nextPermutation(num))
                break;
        }
        return ret;
    }
    
    public boolean nextPermutation(int[] num) {
        if (num.length <= 1) 
            return false;
        int i = num.length - 2, j = num.length - 1, k = num.length - 1;
        while (num[i] >= num[j]) {
            i--;
            j--;
            if (i < 0){
                reverse(num, 0, num.length - 1);
                return false;
            }            	
        }
        while (num[i] >= num[k]) {
        	k--;
        }
        swap(num, i, k);
        reverse(num, j, num.length - 1);
        return true;
    }
    
    public void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    
    public void reverse(int[] num, int i, int j){
    	while (i < j) {
    		swap(num,i,j);
            i++;
            j--;
    	}
    }
}
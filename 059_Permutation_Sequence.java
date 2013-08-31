public class Solution {
    public String getPermutation(int n, int k) {
        int[] factor = new int[n + 1];
        factor[0] = 1;
        String ret = "";
        String ori = "";
        for (int i = 1; i < n + 1; i++) {
            factor[i] = factor[i - 1] * i;
            ori += "" + (char)('0' + i);
        }
        int rem = k - 1;
        for(int i = n - 1; i >= 1; i--){
            int index = rem / factor[i];
            ret += ori.charAt(index);
            ori = ori.substring(0,index) + ori.substring(index + 1);
            rem = rem % factor[i];
        }
        ret += ori;
        return ret;
    }
}
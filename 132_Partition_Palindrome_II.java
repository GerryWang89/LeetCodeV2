public class Solution {
    int[] v;
    int[][] palin;
    public int minCut(String s) {
        v = new int[s.length()];
        palin = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            v[i] = -1;
        }
        return getNum(s,0);
    }
    
    private int getNum(String s, int index){
        if(s.length() == 0)
            return -1;
        if(isPalindrome(s,index,index+s.length()-1))
            return 0;
        if(v[index] != -1)
            return v[index];
        int max = Integer.MAX_VALUE;
        for(int i = 1; i <= s.length(); i++){
            int cut = getNum(s.substring(i),index+i);
            if(isPalindrome(s.substring(0,i),index,index+i-1) && cut < max){
                max = cut;
            }
        }
        v[index] = 1 + max;
        return v[index];
    }
    
    private boolean isPalindrome(String s, int left, int e) {
        if(palin[left][e] != 0){
            return palin[left][e] > 0;
        }
        if (s.length() == 0)
			return true;
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)){
                palin[left][e] = -1;
				return false;
			}
			i++;
			j--;
		}
        palin[left][e] = 1;
		return true;
	}
}
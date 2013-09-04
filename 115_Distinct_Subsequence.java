public class Solution {
    public int numDistinct(String S, String T) {
        int[] v = new int[T.length()+1];
        v[0] = 1;
        for(int i = 1; i <= S.length(); i++){
        	for(int j = T.length(); j > 0; j--){
        		if(S.charAt(i-1) == T.charAt(j-1)){
        			v[j] +=v[j-1];
        		}
        	}
        }
        return v[T.length()];
    }
}
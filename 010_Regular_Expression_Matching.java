public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0)
            return s.length() == 0;
        return solve(s,0,p,0);
    }
    
    public boolean solve(String s, int indexS, String p, int indexP){
        if(indexP >= p.length())
            return indexS >= s.length();
        if(indexP + 1 < p.length() && p.charAt(indexP + 1) == '*'){
            if(indexS >= s.length())
        		return solve(s,indexS, p, indexP + 2);
        	if(s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '.')
        		return solve(s,indexS + 1, p, indexP) || solve(s,indexS, p, indexP + 2);
        	return solve(s,indexS, p, indexP + 2);
        }else{
        	if(indexS < s.length() && (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '.')){
        		return solve(s,indexS + 1, p, indexP + 1);
        	}
        	return false;
        }
    }
}
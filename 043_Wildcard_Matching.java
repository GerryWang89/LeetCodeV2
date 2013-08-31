public class Solution {
    public boolean isMatch(String s, String p) {
    	int star = -1, ss = -1;
		int indexS = 0, indexP = 0;
		while (indexS < s.length()) {
			if (indexP < p.length() && (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '?')) {
				indexS++;
				indexP++;
				continue;
			}
			if (indexP < p.length() && p.charAt(indexP) == '*'){
				star = indexP++;
				ss = indexS;
				continue;
			}
			if (star != -1) {
				indexP = star + 1;
				indexS = ++ss;
				continue;
			}
			return false;
		}
		while (indexP < p.length() && p.charAt(indexP) == '*')
        	indexP++;
        return indexP >= p.length();       
    }
}
public class Solution {
    private HashMap<String, Boolean> hash;
    public boolean isScramble(String s1, String s2) {
        hash = new HashMap<String, Boolean>();
        return solve(s1, s2);
    }
    
    public boolean solve(String s1, String s2){
        if (s1.length() != s2.length()) 
            return false;
        if (s1.equals(s2))
            return true;
        if (hash.containsKey(s1 + " " + s2)) {
            return hash.get(s1 + " " + s2);
        }
        for (int i = 1; i <= s1.length() - 1; i++) {
            if (hash.containsKey(s1 + " " + s2))
                return hash.get(s1 + " " + s2);
            if (solve(s1.substring(0, i), s2.substring(0, i)) 
                && solve(s1.substring(i, s1.length()), s2.substring(i, s2.length()))) {
                hash.put(s1.substring(0, i) + " " + s2.substring(0,i), true);
                hash.put(s1.substring(i, s1.length()) + " " + s2.substring(i, s2.length()), true);
                return true;
            }
            if (solve(s1.substring(0, i), s2.substring(s2.length() - i, s2.length())) 
                && solve(s1.substring(i, s1.length()), s2.substring(0, s2.length() - i))) {
                hash.put(s1.substring(0, i) + " " + s2.substring(s2.length() - i, s2.length()), true);
                hash.put(s1.substring(i, s1.length()) + " " + s2.substring(0, s2.length() - i), true);
                return true;
            }
        }
        hash.put(s1 + " " + s2, false);
        return false;
    }
}
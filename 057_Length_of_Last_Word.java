public class Solution {
    public int lengthOfLastWord(String s) {
        String[] sa = s.trim().split(" ");
        return sa[sa.length - 1].length();
    }
}
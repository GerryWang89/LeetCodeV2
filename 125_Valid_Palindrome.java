public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i < j) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if (!isValid(left)) {
                i++;
                continue;
            }
            if (!isValid(right)) {
                j--;
                continue;
            }
            if (left != right && Math.abs(left-right) != 32) {
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
    
    private boolean isValid(char c) {
        if ((c >= '0' && c <='9') || (c >= 'A' && c <='Z') || (c >= 'a' && c <='z')){
            return true;
        }else{
            return false;
        }
    }
}
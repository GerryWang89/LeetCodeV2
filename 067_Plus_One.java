public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        if (carry == 0)
            return digits;
        else {
            int[] ret = new int[digits.length + 1];
            ret[0] = carry;
            for (int i = 1; i < ret.length; i++) {
                ret[i] = digits[i - 1];
            }
            return ret;
        }
    }
}
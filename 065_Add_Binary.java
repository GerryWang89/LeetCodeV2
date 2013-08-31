public class Solution {
    public String addBinary(String a, String b) {
    	if (a.length() == 0) {
			return b;
		}
		if (b.length() == 0) {
			return a;
		}
		int carry = 0;
		String ret = "";
		int i, j;
		for (i = a.length() - 1, j = b.length() - 1; i >= 0 && j >= 0; i--, j--) {
			int sum = ((a.charAt(i) - '0') + (b.charAt(j) - '0') + carry);
			carry = sum / 2;
			ret = sum % 2 + ret;
		}
		if (i < 0) {
			b = b.substring(0, j + 1);
			if (carry != 0)
				return addBinary(b, carry + "") + ret;
			else
				return b + ret;
		} else {
			a = a.substring(0, i + 1);
			if (carry != 0)
				return addBinary(a, carry + "") + ret;
			else
				return a + ret;
		}
	}
}
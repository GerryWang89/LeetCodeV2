public class Solution {
    public String countAndSay(int n) {
    	// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 1) {
			return "1";
		}
		String ret = "";
		String s = countAndSay(n - 1);
		char temp = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (temp != s.charAt(i)) {
				ret += "" + count + temp;
				count = 1;
				temp = s.charAt(i);
			} else {
				count++;
			}
		}
		ret += "" + count + temp;
		return ret;
	}
}
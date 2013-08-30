//KMP
public class Solution {
    public String strStr(String haystack, String needle) {
    	if (needle.length() == 0)
			return haystack;
		if (haystack.length() < needle.length())
			return null;
		int[] m = getPrefixFunction(needle);
		int q = 0;
		for (int i = 0; i < haystack.length(); i++) {
			while (q > 0 && haystack.charAt(i) != needle.charAt(q)) {
				q = m[q - 1];
			}
			if (haystack.charAt(i) == needle.charAt(q)) {
				q++;
			}
			if (q == needle.length()) {
				return haystack.substring(i - needle.length() + 1);
			}
		}
		return null;
	}

	private int[] getPrefixFunction(String s) {
		char[] p = s.toCharArray();
		int[] m = new int[s.length()];
		m[0] = 0;
		int q = 0;
		for (int i = 1; i < p.length; i++) {
			while (q > 0 && p[q] != p[i])
				q = m[q - 1];
			if (p[i] == p[q]) {
				q++;
			}
			m[i] = q;
		}
		return m;
	}
}
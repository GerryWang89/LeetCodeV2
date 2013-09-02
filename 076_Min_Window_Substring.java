public class Solution {
    public String minWindow(String S, String T) {
    	int[] require = new int[100];
		int[] store = new int[100];
		int start, end;
		int maxLength = Integer.MAX_VALUE;
		for (int i = 0; i < T.length(); i++) {
			require[T.charAt(i) - 'A']++;
		}
		int i = 0, j = 0;
		char cur;
		for (i = 0; i < S.length(); i++) {
			if (require[S.charAt(i) - 'A'] > 0) {
				break;
			}
		}
		for (j = i; j < S.length(); j++) {
			cur = S.charAt(j);
			store[cur - 'A']++;
			int k = 0;
			for (k = 0; k < store.length; k++) {
				if (store[k] < require[k]) {
					break;
				}
			}
			if (k == store.length) {
				break;
			}
		}
		if (j == S.length()) {
			return "";
		}
		while (store[S.charAt(i) - 'A'] > require[S.charAt(i) - 'A']) {
			store[S.charAt(i) - 'A']--;
			i++;
		}
		start = i;
		end = j;
		maxLength = j - i + 1;
		while (j < S.length() - 1) {
			j++;
			cur = S.charAt(j);
			store[cur - 'A']++;
			if (cur == S.charAt(i)) {
				while (store[S.charAt(i) - 'A'] > require[S.charAt(i) - 'A']) {
					store[S.charAt(i) - 'A']--;
					i++;
				}
				if (j - i + 1 < maxLength) {
					maxLength = j - i + 1;
					start = i;
					end = j;
				}
			}
		}
		return S.substring(start, end + 1);
	}
}
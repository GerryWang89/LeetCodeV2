public class Solution {
    private ArrayList<ArrayList<String>> ret;

    public ArrayList<ArrayList<String>> partition(String s) {
		ret = new ArrayList<ArrayList<String>>();
		getAll(s, new ArrayList<String>());
		return ret;
	}

	private void getAll(String s, ArrayList<String> cur) {
		if (s.length() == 0) {
			ret.add(new ArrayList<String>(cur));
		}
		for (int i = 1; i <= s.length(); i++) {
			if (isPalindrome(s.substring(0, i))) {
				cur.add(s.substring(0, i));
				getAll(s.substring(i), cur);
				cur.remove(cur.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s) {
		if (s.length() == 0)
			return true;
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
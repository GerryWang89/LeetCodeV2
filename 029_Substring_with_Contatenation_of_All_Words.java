public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
    	ArrayList<Integer> ret = new ArrayList<Integer>();
		if (L.length == 0)
			return ret;
		int len = L[0].length();
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		for (int i = 0; i < L.length; i++) {
			hash.put(L[i], hash.containsKey(L[i]) ? hash.get(L[i]) + 1 : 1);
		}
		HashMap<String, Integer> back = new HashMap<String, Integer>(hash);
		for (int i = 0; i < len; i++) {
			int match = 0;
			for (int j = i; j + len * L.length - 1 < S.length(); j += len) {
				for (int k = j; k <= S.length() - len; k += len) {
					if (hash.containsKey(S.substring(k, k + len)) && hash.get(S.substring(k, k + len)) > 0) {
						match++;
						hash.put(S.substring(k, k + len), hash.get(S.substring(k, k + len)) - 1);
						if (match == L.length)
							ret.add(j);
					} else {
						if (match != 0) {
							hash = new HashMap<String, Integer>(back);
							match = 0;
						}
						break;
					}
				}
			}
		}
		return ret;
	}
}
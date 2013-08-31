public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
    	ArrayList<String> ret = new ArrayList<String>();
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		String[] key = new String[strs.length];
		for (int i = 0; i < strs.length; i++) {
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			String temp = new String(chars);
			key[i] = temp;
			if (hash.containsKey(temp)) {
				hash.put(temp, hash.get(temp) + 1);
			} else {
				hash.put(temp, 1);
			}
		}
		for (int i = 0; i < key.length; i++) {
			if (hash.get(key[i]) > 1) {
				ret.add(strs[i]);
			}
		}
		return ret;
	}
}
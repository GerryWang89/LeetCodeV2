public class Solution {
    private ArrayList<ArrayList<String>> ret;
    private HashMap<String, ArrayList<String>> pres;

	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		boolean reach = false;
		ret = new ArrayList<ArrayList<String>>();
		pres = new HashMap<String, ArrayList<String>>();
		Queue<String> preQ = new LinkedList<String>();
		Queue<String> curQ = new LinkedList<String>();
		curQ.offer(start);
		pres.put(start, null);
		dict.remove(start);
		dict.remove(end);
		ArrayList<String> deList = new ArrayList<String>();
		while (!curQ.isEmpty() && !reach) {
			preQ = curQ;
			curQ = new LinkedList<String>();
			deList.clear();
			while (!preQ.isEmpty()) {
				String cur = preQ.poll();
				for (int i = 0; i < cur.length(); i++) {
					for (int j = 0; j <= 'z' - 'a'; j++) {
						String tmp = cur.substring(0, i) + (char)('a' + j) + cur.substring(i + 1);
						if ((char)('a' + j) == cur.charAt(i))
							continue;
						if (tmp.equals(end)) {
							reach = true;
							ArrayList<String> ans = new ArrayList<String>();
							ans.add(end);
							ans.add(cur);
							addToRet(cur, ans);
						}
						if (dict.contains(tmp)) {
							if (!deList.contains(tmp)){
								deList.add(tmp);
								curQ.offer(tmp);
							}
							if (pres.containsKey(tmp)) {
								pres.get(tmp).add(cur);
							} else {
								ArrayList<String> genePreList = new ArrayList<String>();
								genePreList.add(cur);
								pres.put(tmp, genePreList);
							}
						}
					}
				}
			}
			dict.removeAll(deList);
		}
		return ret;
	}

	private void addToRet(String s, ArrayList<String> cur) {
		if (pres.get(s) == null) {
			ArrayList<String> addList = new ArrayList<String>(cur);
			Collections.reverse(addList);
			ret.add(addList);
			return;
		}
		for (String item : pres.get(s)) {
			cur.add(item);
			addToRet(item, cur);
			cur.remove(cur.size() - 1);
		}
	}
}
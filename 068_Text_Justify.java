public class Solution {
    private ArrayList<String> ret;

    public ArrayList<String> fullJustify(String[] words, int L) {
		ret = new ArrayList<String>();

		if (words.length == 0)
    		return ret;
		if (L == 0){
			for (String word : words)
				ret.add(word);
			return ret;
		}
		int base = 0, cur = 0;
		for (int i = 0; i < words.length; i++) {
			if (cur + (i == base ? 0 : 1) + words[i].length() > L) {
				ret.add(generateLine(words, base, i, L));
				base = i--;
				cur = 0;
			} else {
				cur += (i == base ? 0 : 1) + words[i].length();
			}
		}
		String left = words[base];
		for (int i = base + 1; i < words.length; i++) {
			left += " " + words[i];
		}
		for (int i = left.length(); i < L; i++) {
			left += " ";
		}
		ret.add(left);
		return ret;
	}

	private String generateLine(String[] words, int base, int to, int L) {
		String ret = words[base];
		int len = 0;
		for (int i = base; i < to; i++)
			len += words[i].length();
		int spaceNum = L - len;
		if (to - base == 1) {
			for (int i = 0; i < spaceNum; i++)
				ret += " ";
			return ret;
		}
		int left = spaceNum % (to - base - 1);
		List<String> spaces = new ArrayList<String>();
		String single = "";
		for (int i = 0; i < spaceNum / (to - base - 1); i++)
			single += " ";
		for (int i = base + 1; i < to; i++) {
			ret += (left-- > 0 ? single + " " : single) + words[i];
		}
		return ret;
	}
}







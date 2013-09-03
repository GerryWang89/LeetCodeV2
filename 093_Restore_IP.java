public class Solution {
	private ArrayList<String> ret;

	public ArrayList<String> restoreIpAddresses(String s) {
		ret = new ArrayList<String>();
		if (s.length() < 4 || s.length() > 12) {
			return ret;
		}
		getIP("", s, 4);
		return ret;
	}

	private void getIP(String pre, String s, int seg) {
		if (s.length() > 3 * seg || s.length() < seg) {
			return;
		}
		if (seg == 1) {
			if (Integer.parseInt(s) > 255
					|| s.length() > (Integer.parseInt(s) + "").length()) {
				return;
			} else {
				ret.add(pre + s);
			}
		}
		for (int i = 0; i < 3 && i < s.length(); i++) {
			String tmp = s.substring(0, i + 1);
			if (Integer.parseInt(tmp) <= 255) {
				getIP(pre + tmp + ".", s.substring(i + 1), seg - 1);
			}
			if (tmp.equals("0")) {
				break;
			}
		}
	}
}
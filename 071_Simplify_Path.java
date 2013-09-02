public class Solution {
    public String simplifyPath(String path) {
    	path = path.replaceAll("[/]{2,}", "/");
		ArrayList<String> dir = new ArrayList<String>();
		if (path == null || path.length() == 0)
			return "";
		if (path.charAt(path.length() - 1) != '/')
			path += "/";
		int base = 0;
		for (int i = base + 1; i < path.length(); i++) {
			if (path.charAt(i) == '/') {
				if (path.substring(base + 1, i).equals("..")) {
					if (!dir.isEmpty())
						dir.remove(dir.size() - 1);
					base = i;
				} else if (path.substring(base + 1, i).equals(".")) {
					base = i;
				} else if (i + 1 >= path.length()) {
					dir.add(path.substring(base + 1, i));
					base = i;
					break;
				} else {
					dir.add(path.substring(base + 1, i));
					base = i;
				}
			}
		}
		String ret = "";
		for (int i = 0; i < dir.size(); i++) {
			ret += "/" + dir.get(i);
		}
		return ret.length() == 0 ? "/" : ret;
	}
}
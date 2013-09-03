public class Solution{	
	private int[] v;

	public int numDecodings(String s) {
		if (s.length() == 0 || s.equals("0") || s.charAt(0) == '0') {
			return 0;
		}
		for(int i = 1; i < s.length(); i++){
			if(s.charAt(i) == '0' && s.charAt(i-1) != '1' && s.charAt(i-1) != '2'){
				return 0;
			}
		}
		v = new int[s.length()];
		return getNumbers(s);
	}

	private int getNumbers(String s) {
		if (s.length() == 0) {
			return 1;
		}
		if (s.length() == 1) {
			return 1;
		}
		if (s.length() == 2) {
			if ( Integer.parseInt(s) <= 26 && s.charAt(1) != '0' )
				return 2;
			else
				return 1;
		}
		if (s.charAt(s.length() - 1) == '0') {
			if (v[s.length() - 3] == 0)
				v[s.length() - 3] = getNumbers(s.substring(0, s.length() - 2));
			return v[s.length() - 3];
		}
		if (Integer.parseInt(s.substring(s.length() - 2, s.length())) > 26 || s.charAt(s.length()-2) =='0') {
			if (v[s.length() - 2] == 0)
				v[s.length() - 2] = getNumbers(s.substring(0, s.length() - 1));
			return v[s.length() - 2];
		} else {
			if (v[s.length() - 3] == 0)
				v[s.length() - 3] = getNumbers(s.substring(0, s.length() - 2));
			if (v[s.length() - 2] == 0)
				v[s.length() - 2] = getNumbers(s.substring(0, s.length() - 1));
			return v[s.length() - 3] + v[s.length() - 2];
		}
	}
}
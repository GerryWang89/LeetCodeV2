public class Solution{
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int num = 1 << n;
		for (int i = 0; i < num; i++) {
			ret.add(i ^ (i >> 1));
		}
		return ret;
	}
}
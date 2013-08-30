public class Solution {
    public int divide(int dividend, int divisor) {
    	boolean isPos = (dividend < 0 && divisor < 0) || (dividend >= 0 && divisor >= 0);
    	long dd = 0, ds = 0;
		dd = Math.abs((long)dividend);
		ds = Math.abs((long)divisor);
		long res = 0, cur = 0;
		for (int idx = 31; idx >= 0; idx--) {
			cur <<= 1;
			cur |= ((dd >> idx) & 1);
			res = res << 1;
			if (cur >= ds) {
				cur -= ds;
				res |= 1;
			}
		}
		return isPos ? (int)res : -(int)res;
	}
}
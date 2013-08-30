public class Solution {
    class pHolder {
		public int index;
		public char value;

		public pHolder(int index, char value) {
			this.index = index;
			this.value = value;
		}
	}

	public int longestValidParentheses(String s) {
		if (s.length() < 2) {
			return 0;
		}
		int ret = 0;
		Stack<pHolder> stack = new Stack<pHolder>();
		stack.push(new pHolder(-1, ')'));
		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty()) {
				stack.push(new pHolder(i, s.charAt(i)));
			} else {
				if (stack.peek().value == '(' && s.charAt(i) == ')') {
					stack.pop();
					ret = Math.max(ret, i - stack.peek().index);
				} else {
					stack.push(new pHolder(i, s.charAt(i)));
				}
			}
		}
		return ret;
	}
}
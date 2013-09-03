/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int[] num;

    public TreeNode sortedArrayToBST(int[] num) {
		this.num = num;
		return getBST(0, num.length - 1);
	}

	private TreeNode getBST(int start, int end) {
		if (start == end) {
			return new TreeNode(num[start]);
		}
		if (start > end) {
			return null;
		}
		TreeNode curNode = new TreeNode(num[(start + end) / 2]);
		curNode.left = getBST(start, (start + end) / 2 - 1);
		curNode.right = getBST((start + end) / 2 + 1, end);
		return curNode;
	}
}
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
    int[] postorder, inorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
		this.postorder = postorder;
		this.inorder = inorder;
		return getTree(0, postorder.length - 1, 0, inorder.length - 1);
	}

	public TreeNode getTree(int postStart, int postEnd, int inStart, int inEnd) {
		if (postStart == postEnd)
			return new TreeNode(postorder[postStart]);
		if (postEnd < postStart || inEnd < inStart)
			return null;
		TreeNode ret = new TreeNode(postorder[postEnd]);
		int pivot = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == postorder[postEnd]) {
				pivot = i;
				break;
			}
		}
		ret.left = getTree(postStart, postStart + (pivot - inStart - 1), inStart,
				pivot - 1);
		ret.right = getTree(postStart + (pivot - inStart), postEnd - 1,
				pivot + 1, inEnd);
		return ret;
	}
}
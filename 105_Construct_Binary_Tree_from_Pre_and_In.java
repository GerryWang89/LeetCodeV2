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
    int[] preorder, inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.preorder = preorder;
		this.inorder = inorder;
		return getTree(0, preorder.length - 1, 0, inorder.length - 1);
	}

	public TreeNode getTree(int preStart, int preEnd, int inStart, int inEnd) {
		if (preStart == preEnd)
			return new TreeNode(preorder[preStart]);
		if (preEnd < preStart || inEnd < inStart)
			return null;
		TreeNode ret = new TreeNode(preorder[preStart]);
		int pivot = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == preorder[preStart]) {
				pivot = i;
				break;
			}
		}
		ret.left = getTree(preStart + 1, preStart + (pivot - inStart), inStart,
				pivot - 1);
		ret.right = getTree(preStart + (pivot - inStart) + 1, preEnd,
				pivot + 1, inEnd);
		return ret;
	}
}
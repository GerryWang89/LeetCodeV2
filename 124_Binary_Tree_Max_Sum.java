public class Solution {
    private int max;
	
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        solve(root);
        return max;
    }
    
    public int solve(TreeNode root){
        if (root == null)
            return 0;
        int left = solve(root.left);
        int right = solve(root.right);
        max = Math.max(max, (left + right + root.val));
        int endSum = Math.max(Math.max(left, right) + root.val, root.val);
        max = Math.max(max, endSum);
        return endSum;
    }
}
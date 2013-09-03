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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return solve(root.left, root.right);
    }
    
    private boolean solve(TreeNode p, TreeNode q){
        if(p == null || q == null)
            return p == null && q == null;
        boolean left = solve(p.left,q.right);
        boolean val = p.val == q.val;
        boolean right = solve(p.right,q.left);
        return left && val && right;
    }
}
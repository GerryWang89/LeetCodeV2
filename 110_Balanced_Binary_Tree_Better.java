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
    
    public boolean isBalanced(TreeNode root) {
        return solve(root) != -1;
    }
    private int solve(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = solve(root.left);
        int right = solve(root.right);
        if (left == -1 || right == -1)
            return -1;
        if (Math.abs(left - right) > 1) 
            return -1;
        return 1 + (left > right ? left : right);
    }
}
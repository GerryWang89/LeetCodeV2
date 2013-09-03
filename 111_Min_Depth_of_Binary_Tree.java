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
    public int minDepth(TreeNode root) {
        if (root == null) 
            return 0;
        return solve(root);
    }
    
    public int solve(TreeNode root){
        if (root == null) 
            return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) 
            return 1;
        return (Math.min(solve(root.left),solve(root.right))) + 1;
    }
}
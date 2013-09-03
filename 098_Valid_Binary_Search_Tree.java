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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (findMax(root.left) < root.val && findMin(root.right) > root.val) {
            return isValidBST(root.left) && isValidBST(root.right);
        } else {
            return false;
        }
    }
    
    public int findMax(TreeNode node){
        if (node == null)
            return Integer.MIN_VALUE;
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }
    
    public int findMin(TreeNode node){
        if (node == null)
            return Integer.MAX_VALUE;
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }
}
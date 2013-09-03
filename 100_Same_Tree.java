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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p,q);
    }
    
    private boolean isSame(TreeNode p, TreeNode q){
        if(p == null || q == null)
            return p == null && q == null;
        boolean left = isSame(p.left,q.left);
        boolean val = p.val == q.val;
        boolean right = isSame(p.right,q.right);
        return left && val && right;
    }
}
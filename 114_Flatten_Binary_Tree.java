public class Solution {
    public void flatten(TreeNode root) {
         solve(root);
    }
    
    public TreeNode solve(TreeNode root){
        if (root == null)
            return null;
        TreeNode left = solve(root.left);
        TreeNode right = solve(root.right);
        if (left == null)
            return root;
        root.left = null;
        root.right = left;
        while (left.right != null)
            left = left.right;
        left.right = right;
        return root;
    }
}
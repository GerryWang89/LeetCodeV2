public class Solution {
    private int ret;
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        ret = 0;
        solve(root, 0);
        return ret;
    }
    
    public void solve(TreeNode root, int cur){
        if (root == null)
            return;
        if (root.left == null && root.right == null){
            ret += cur * 10 + root.val;
            return;
        }
        solve(root.left, cur * 10 + root.val);
        solve(root.right, cur * 10 + root.val);
    }
}
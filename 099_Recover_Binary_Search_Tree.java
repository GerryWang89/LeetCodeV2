public class Solution {
    private ArrayList<TreeNode> nodeList;
    private TreeNode pre;
    public void recoverTree(TreeNode root) {
        nodeList = new ArrayList<TreeNode>();
        pre = null;
        inorder(root);
        int tmp = nodeList.get(0).val;
        nodeList.get(0).val = nodeList.get(nodeList.size() - 1).val;
        nodeList.get(nodeList.size() - 1).val = tmp;
    }
    public void inorder(TreeNode root) {
        if (root == null) 
            return;
        inorder(root.left);
        if (pre != null && pre.val > root.val) {
            nodeList.add(pre);
            nodeList.add(root);
        }
        pre = root;
        inorder(root.right);
    }
}
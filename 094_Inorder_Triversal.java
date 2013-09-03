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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<MyNode> stk = new Stack<MyNode>();
        stk.push(new MyNode(root,false));
        while (!stk.isEmpty()) {
            if (stk.peek().treeNode == null){
                stk.pop();
                continue;
            }
            if (stk.peek().isVisited) {
                MyNode tmp = stk.pop();
                ret.add(tmp.treeNode.val);
                stk.push(new MyNode(tmp.treeNode.right, false));
            } else {
                stk.peek().isVisited = true;
                stk.push(new MyNode(stk.peek().treeNode.left, false));
            }
        }
        return ret;
    }
    
    class MyNode{
        TreeNode treeNode;
        boolean isVisited;
        
        public MyNode(TreeNode treeNode, boolean isVisited){
            this.treeNode = treeNode;
            this.isVisited = isVisited;
        }
    }
}
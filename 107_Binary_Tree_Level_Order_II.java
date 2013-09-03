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
    private ArrayList<ArrayList<Integer>> ret;
    
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ret = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
        	queue = getElementsOfALevel(queue);
        }
        Collections.reverse(ret);
        return ret;
    }
	
	private Queue<TreeNode> getElementsOfALevel(Queue<TreeNode> queue){
		Queue<TreeNode> ret = new LinkedList<TreeNode>();
		ArrayList<Integer> appendList = new ArrayList<Integer>();
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			appendList.add(node.val);
			if(node.left != null){
				ret.offer(node.left);
			}
			if(node.right != null){
				ret.offer(node.right);
			}
		}
		this.ret.add(appendList);
		return ret;
	}
}
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
    	if (root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		Queue<TreeLinkNode> buffer = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			while (!queue.isEmpty()) {
				TreeLinkNode node = queue.poll();
				node.next = queue.peek();
				if (node.left != null)
					buffer.offer(node.left);
				if (node.right != null)
					buffer.offer(node.right);
			}
			queue = new LinkedList<TreeLinkNode>(buffer);
			buffer.clear();
		}
	}
}
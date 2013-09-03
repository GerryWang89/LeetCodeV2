public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode p = head;
        int len = 1;
        while (p != null) {
            p = p.next;
            len++;
        }
        return solve(head, len);
    }
    
    public TreeNode solve(ListNode head, int len){
        if (head == null) 
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        ListNode p = null, q = head;
        for (int i = 1; i < (len + 1) / 2; i++) {
            p = q;
            q = q.next;
        }
        TreeNode root = new TreeNode(q.val);
        if (p == null)
            root.left = null;
        else {
            p.next = null;
            root.left = solve(head, (len + 1) / 2 - 1);
        }
        root.right = solve(q.next, len - (len + 1) / 2);
        return root;
    }
}
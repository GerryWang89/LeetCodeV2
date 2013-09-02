/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode holder = new ListNode(0);
        holder.next = head;
        ListNode p, q;
        if (head == null || head.next == null)
            return head;
        p = head;
        q = head.next;
        while (q != null) {
            if (q.val == p.val) {
                q = q.next;
            } else {
                p.next = q;
                p = q;
                q = q.next;
            }
        }   
        p.next = null;
        return holder.next;
    }
}
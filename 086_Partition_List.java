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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) 
            return head;
        ListNode holder = new ListNode(0);
        ListNode bigList = new ListNode(0);
        holder.next = head;
        ListNode p, q, r;
        p = holder;
        q = p.next;
        r = bigList;
        while (q != null) {
            if (q.val >= x) {
                r.next = q;
                r = r.next;
                q = q.next;
                p.next = q;
            } else {
                p = q;
                q = q.next;
            }
        }
        p.next = bigList.next;
        r.next = null;
        return holder.next;
    }
}
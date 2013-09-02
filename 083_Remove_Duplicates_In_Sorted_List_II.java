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
        ListNode p, q, r;
        if (head == null || head.next == null)
            return head;
        p = holder;
        q = head;
        r = head.next;
        while (r != null) {
            if (q.val == r.val) {
                while (r != null && q.val == r.val) {
                    r = r.next;
                }
                if (r == null) {
                    if (q.next == null) {
                        p.next = q;
                        return holder.next;
                    }
                    break;
                }
                q = r;
                r = r.next;
            } else {
                p.next = q;
                p = q;
                q = r;
                r = r.next;
            }
        }
        if (q.next == null) {
            p.next = q;
            return holder.next;
        }
        p.next = null;
        return holder.next;
    }
}
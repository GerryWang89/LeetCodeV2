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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || n <= m) 
            return head;
        ListNode hold = new ListNode(0);
        hold.next = head;
        ListNode pre, tail, p, q, r;
        p = hold;
        q = hold.next;
        for (int i = 0; i < m; i++) {
            p = q;
            q = q.next;
        }
        pre = p;
        tail = q;
        p = q;
        q = q.next;
        r = q.next;
        for (int i = 0; i < n - m; i++) {
            q.next = p;
            p = q;
            q = r;
            r = r.next;
        }
        pre.next = q;
        tail.next = r;
        return hold.next;
    }
}
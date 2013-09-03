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
        if(m == n || head == null || head.next == null){
            return head;
        }
        ListNode pre, post;
        ListNode ori = new ListNode(0);
        ori.next = head;
        head = ori;
        ListNode p = head;
        ListNode q = p.next;
        ListNode r = q.next;
        int index = 1;
        while(index < m){
            index++;
            p = q;
            q = r;
            r = r.next;
        }
        if (n - m == 1) {
            q.next = r.next;
            p.next = r;
            r.next = q;
            return head.next;
        }
        pre = p;
        post = q;
        index++;
        p = q;
        q = r;
        r = r.next;
        while(index < n - 1){
            q.next = p;
            p = q;
            q = r;
            r = r.next;
            index++;
        }
        q.next = p;
        post.next = r.next;
        r.next = q;
        pre.next = r;
        return head.next;
    }
}
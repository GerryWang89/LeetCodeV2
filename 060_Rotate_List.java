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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null)
            return head;
        int len = 1;
        ListNode ret, p = head;
        while (p.next != null) {
            len++;
            p = p.next;
        }
        if (n % len == 0) 
            return head;
        p.next = head;
        p = head;
        for (int i = 0; i < len - n % len - 1; i++) {
            p = p.next;
        }
        ret = p.next;
        p.next = null;        
        return ret;
    }
}
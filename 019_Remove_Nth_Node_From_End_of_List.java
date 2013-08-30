public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode p = head;
        while(p != null){
            len++;
            p = p.next;
        }
        ListNode ori = new ListNode(0);
        ori.next = head;
        p = ori;
        for(int i = 0; i < len - n; i++){
            p = p.next;
        }
        p.next = p.next.next;
        return ori.next;
    }
}
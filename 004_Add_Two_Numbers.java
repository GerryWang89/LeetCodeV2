public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        int carry = 0;
        ListNode p = l1, q = l2;
        while(p.next != null && q.next != null){
            int sum = p.val + q.val + carry;
            carry = sum / 10;
            p.val = sum % 10;
            p = p.next;
            q = q.next;
        }
        int sum = p.val + q.val + carry;
        carry = sum / 10;
        p.val = sum % 10;
        if (p.next == null) {
            if (carry == 0)
                p.next = q.next;
            else{
                p.next = addTwoNumbers(new ListNode(carry),q.next);
            }
        } else {
            if (carry != 0){
                p.next = addTwoNumbers(new ListNode(carry),p.next);
            }
        }
        return l1;
    }
}
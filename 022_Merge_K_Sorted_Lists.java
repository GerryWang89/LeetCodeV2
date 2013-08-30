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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0)
            return null;
    	PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),
				new PriorityComparator());
		for (ListNode node : lists) {
			if (node != null)
				pq.add(node);
		}
		ListNode ret = new ListNode(0);
		ListNode p = ret;
		while (!pq.isEmpty()) {
			ListNode tmp = pq.poll();
			p.next = tmp;
			if (tmp.next != null)
				pq.add(tmp.next);
			p = p.next;
		}
		return ret.next;
	}
    
    class PriorityComparator implements Comparator<ListNode> {
    	@Override
		public int compare(ListNode n1, ListNode n2) {
			return n1.val - n2.val;
		}
	}
}
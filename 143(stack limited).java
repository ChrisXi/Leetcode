/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

	ListNode h;
    public void reorderList(ListNode head) {
        h = head;

        if(h == null || h.next == null || h.next.next == null)
        	return;

        ListNode p1 = head.next;
        ListNode p2 = head.next.next;

        while(p2 != null && p2.next != null) {
        	p1 = p1.next;
        	p2 = p2.next.next;
        }
        
        ListNode p = p1.next;
        p1.next = null;
        change(p);
    }

    public ListNode change(ListNode n) {

    	if(n.next == null) {

    		ListNode temp = h.next;
    		h.next = n;
    		n.next = temp;

    		return temp;
    	}

    	ListNode pre = change(n.next);
    	
    	if(pre == null)
    	    return null;
    	
    	ListNode temp = pre.next;
    	pre.next = n;
    	n.next = temp;

    	return temp;
    }
}
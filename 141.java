/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head == null)
        	return false;

        ListNode p1 = head.next;
        ListNode p2 = head.next;

        if(p2 != null) {
    		p2 = p2.next;
    	} else {
    		return false;
    	}

        while(p1!=null && p2!=null) {
        	if(p1 == p2) {
        		return true;
        	}

        	p1 = p1.next;
        	p2 = p2.next;

        	if(p2 != null) {
        		p2 = p2.next;
        	} else {
        		return false;
        	}
        }

        return false;
    }
}
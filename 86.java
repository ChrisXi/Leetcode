/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {

    	if(head == null)
    		return head;

        ListNode start = null;
        ListNode loop = null;
        ListNode pre = null;
        ListNode post = null;
        ListNode end = null;
        ListNode mid = null;

        end = head;

        while(end.next != null) {
        	end = end.next;
        }

        loop = head;
        while(loop != null) {

        	if(mid != null && loop == mid)
        		break;

        	int val = loop.val;
        	if(val >= x) {

        		if(mid == null) {
        			mid = loop;
        		}

        		post = loop.next;
        		end.next = loop;
        		end = loop;
        		end.next = null;
        		loop = post;
        		
        		if(pre != null && post != null) {
        			pre.next = post;
        		}
        	} else {
        		if(start == null) {
        			start = loop;
        		}
        		pre = loop;
        		loop = loop.next;
        	}
    	}

    	if(start == null)
    		start = head;

    	return start;
    }
        
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
    
    	ListNode loop = head;
    	ListNode h = null;

    	ListNode tempH = null;
    	ListNode tempE = null;

    	int n = 0;
    	while(loop != null) {
    		n ++;
    		ListNode post = loop.next;
    		if(n == 1) {
    			tempE = loop;
    		} else if(n == k) {
    			tempH = loop;

    			if(h == null) {
    				h = tempH;
    			}

    			if(add(tempE, k) != null) 
    				tempE.next = post;

    			n = 0;
    		}
    		loop = post;
    	}   

    	if(h == null)
    		return head;


    	return h;
    }

    public ListNode add(ListNode n, int k) {

    	k = k-1;
    	if(k == 0) {
    		return n;
    	} else {
    		if(n.next == null)
    			return null;

    		ListNode cur = add(n.next, k);
    		if(cur != null) {
    			cur.next = n;
    			return n;
    		} else {
    			return null;
    		}
    	}
    }
 }






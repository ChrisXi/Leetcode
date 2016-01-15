/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Pointer {
    ListNode h;
    ListNode t;
    Pointer(ListNode h, ListNode t) {this.h = h; this.t =t;}
    Pointer() {}
}

public class Solution {
    public ListNode sortList(ListNode head) {
    	
    	return sortSubList(head).h;
    }

    public Pointer sortSubList(ListNode head) {

    	if(head == null || head.next == null) {
    	    
    	    Pointer p = new Pointer(head, head);
    	    
    		return p;
    	}
    	
    	int val = head.val;

    	ListNode loop = head.next;
    	head.next = null;

    	ListNode s1 = null;
    	ListNode s2 = null;
    	ListNode e1 = null;
    	ListNode e2 = null;

    	while(loop != null) {

    		ListNode post = loop.next;
    		loop.next = null;

    		if(loop.val < val) {

    			if(s1 == null) {
    				s1 = loop;
    				s2 = s1;
    			} else {
    				s2.next = loop;
    				s2 = loop;
    			}

    		} else {

    			if(e1 == null) {
    				e1 = loop;
    				e2 = e1;
    			} else {
    				e2.next = loop;
    				e2 = loop;
    			}
    		}

    		loop = post;
    	}

        Pointer p1 = sortSubList(s1); //left
        Pointer p2 = sortSubList(e1); //right

        Pointer p = new Pointer();
        
        if(p1.h != null) {
        	p1.t.next = head;
        	p.h = p1.h;
        } else {
            p.h = head;
        }
    
        if(p2.h != null) {
            head.next = p2.h;
            p.t = p2.t;
        } else {
            p.t = head;
        }
    
        return p;
        
    }	
}



 


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n || head == null)
            return head;
            
        int count = 0;
        ListNode temp = head;
        ListNode start = null;
        ListNode pre = null;
        ListNode post = null;
        ListNode n1 = null;
       
        while(temp != null) {
        	count ++;
            if(count == m-1) {
            	start = temp;
            } else if(count == m) {
            	n1 = temp;
            	pre = temp;
            } else if(m<count && count<=n) {
            	post = temp.next;
            	temp.next = pre;

            	if(count == n) {
            		if(start == null) {
            			start = temp;
            			head = start;
            		} else {
            			start.next = temp;
            		}
            		n1.next = post;
            		break;
            	} else {
            		pre = temp;
            		temp = post;
            	}
            	continue;
        	} 
            temp = temp.next;
        }

        return head;
    }

    
}
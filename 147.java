/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        
        if(head == null)
            return head;
        
        ListNode tail = head;
        ListNode cur = head.next;
        head.next = null;
        
        while(cur != null) {
            
            ListNode check = cur;
            ListNode loop = head;
            ListNode post = cur.next;
            
            boolean insert = false;
            while(loop != null) {

            	if(check.val < loop.val) {
            		int temp = check.val;
            		check.val = loop.val;
            		loop.val = temp;
            		
            		check.next = loop.next;
            		loop.next = check;
            		
            		insert = true;

            		break;
            	}

            	loop = loop.next;
            }

            if(!insert) {
            	tail.next = check;
            	check.next = null;
            	tail = check;
            }

           	cur = post;
        }

        return head;
        
    }
}
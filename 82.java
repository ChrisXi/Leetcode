/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        int lastValue = head.val;
        ListNode temp = head.next;
        ListNode start = head;

        do {
        	int value = temp.val;
        	if(lastValue == value) {
        		start = null;
        	} else {
        		if(start == null) {
        			start = temp;
        			lastValue = temp.val;
        		} else {
        			break;
        		}
        	}

        	temp = temp.next;

        } while(temp != null);

        if(start == null || start.next == null || start.next.next == null)
        	return start;


        ListNode pos = start;
        ListNode newNode = start.next;
        ListNode newNext = newNode.next;
        lastValue = newNode.val;
        while(newNext != null) {
            int value = newNext.val;
            if(value == lastValue) {
            	newNode = null;
            } else {
            	if(newNode == null) {
            		newNode = newNext;
            		lastValue = newNext.val;
            		if(newNext.next == null) {
            			pos.next = newNode;
            			pos = newNode;
            			break;
            		}
            	} else {
            		pos.next = newNode;
            		pos = newNode;
            		newNode = newNode.next;

            		if(newNode == null)
            			break;

            		if(newNode.next == null) {
            			pos.next = newNode;
            			pos = newNode;
            			break;
            		}

            		lastValue = newNode.val;
            	}
            }

        	newNext = newNext.next;
        }
        pos.next = null;

        return start;
    }
}
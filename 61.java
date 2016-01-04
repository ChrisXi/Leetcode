/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null)
        	return head;

        ListNode pos = head;
        ListNode tail = head;

        int count = 1;
        while(tail.next != null) {
        	count ++;
        	tail = tail.next;
        }

        tail = head;
        k = k%count;

        if(k == 0)
        	return head;

        count = 0;
        while(tail.next != null && count < k) {
        	count ++;
        	tail = tail.next;
        }

        if(count < k)
        	return head;

        while(tail.next != null) {
        	tail = tail.next;
        	pos = pos.next;
        }

        ListNode start = pos.next;
        pos.next = null;
        tail.next = head;

        return start;

    }
}
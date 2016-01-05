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
        if(head == null)
            return null;
        
        int lastValue = head.val;
        ListNode temp = head.next;
        ListNode pos = head;
        while(temp != null) {
            int value = temp.val;
            if(value != lastValue) {
            	pos.next = temp;
            	pos = temp;
            	lastValue = value;
            }
        	temp = temp.next;
        }
        pos.next = null;

        return head;
    }
}
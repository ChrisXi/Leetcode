/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {

        if(null == head || null == head.next) {
        	return head;
        }

        ListNode tempHead = head.next;
        ListNode nextHead = tempHead.next;

        tempHead.next = head;
        head.next = nextHead;

        ListNode pairHead = head;

        while(null != nextHead && null != nextHead.next) {

        	ListNode tempH = nextHead.next;
        	ListNode tempNextHead = tempH.next;

        	tempH.next = nextHead;
        	nextHead.next = tempNextHead;

        	pairHead.next = tempH;

        	pairHead = nextHead;
        	nextHead = tempNextHead;
        }

        return tempHead;

    }
}
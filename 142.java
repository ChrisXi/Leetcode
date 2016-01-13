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
    public ListNode detectCycle(ListNode head) {
        
        if(head == null)
            return null;

        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = null;

        int count = 0;
        while(p2!=null && p2.next!=null) {

            if(count == 0) {
                p1 = p1.next;
                p2 = p2.next.next;
            } else {
                p1 = p1.next;
                p3 = p3.next;
            }

            if(p1 == p2) {
                count ++;
                p3 = head;
            }

            if(p1 == p3) {
                return p1;
            }

        }

        return null;
    }
}
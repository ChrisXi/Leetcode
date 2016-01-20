/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

       
        int no = check(head, n);

        if(no == n) {
            return head.next;
        }

        return head;
    }

    public int check(ListNode node, int n) {
        if(node == null) {
            return 0;
        }

        int no = check(node.next, n);

        if(no == n+1) {
            node.next = node.next.next;
        }

        return no+1;
    }
}
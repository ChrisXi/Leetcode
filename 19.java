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

        int index=1;
        ListNode tempNode = head;
        while(index != n && tempNode.next != null){
            tempNode = tempNode.next;
            index ++;
        }
        if(n == index) {
            ListNode delNode = head;
            ListNode preNode = delNode;
            if(tempNode.next == null)
                return delNode.next;
            while(tempNode.next != null) {
                preNode = delNode;
                tempNode = tempNode.next;
                delNode = delNode.next;
            }
            preNode.next = delNode.next;
            
        } else {
            return null;
        }
        
        return head;
    }
}
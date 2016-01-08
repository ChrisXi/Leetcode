/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        
        return addChild(head);
    }

    public TreeNode addChild(ListNode head) {

    	ListNode mid = head;
    	ListNode end = head;

    	if(mid == null) {
    		return null;
    	}

    	if(mid.next == null) {
    		return new TreeNode(mid.val);
    	} 

    	if(mid.next.next == null) {
    		TreeNode node = new TreeNode(mid.next.val);
    		node.left = new TreeNode(mid.val);
    		return node;
    	}

    	end = end.next;

    	while(end.next != null && end.next.next != null) {
    		mid = mid.next;
    		end = end.next.next;
    	}
    
    	
    	TreeNode node = new TreeNode(mid.next.val);

    	ListNode temp = mid.next.next;
    	mid.next = null;

    	node.left = addChild(head);
    	node.right = addChild(temp); 

    	return node;
    }
}



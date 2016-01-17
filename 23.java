/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNodeComparator implements Comparator<ListNode>{
	public int compare(ListNode n1, ListNode n2) {
		return n1.val - n2.val;
	}
}

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<ListNode>(new ListNodeComparator());

        int len = lists.length;
        for(int i=0; i<len; i++) {
        	if(lists[i] != null)
        		q.offer(lists[i]);
        }

        ListNode h = null;
        ListNode t = null;
        while(!q.isEmpty()) {
        	ListNode temp = q.poll();
        	if(temp.next != null) {
        		q.offer(temp.next);
        	}
        	temp.next = null;

        	if(h == null){
        		h = temp;
        		t = h;
        	} else {
        		t.next = temp;
        		t = temp;
        	}
        }

        return h;
    }
}
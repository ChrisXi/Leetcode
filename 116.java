/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
    	
    	if(root == null)
    		return;

    	Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
    	q.offer(root);

    	TreeLinkNode pre = null;
    	int count = 1;
    	int curNum = 0;
    	int nextNum = 0;

    	do {

    		curNum ++;

    		TreeLinkNode node = q.poll();

    		if(pre != null) {
    			pre.next = node;
    		} 
    		
    		pre = node;
    		
    		if(node.left != null) {
    			q.offer(node.left);
    			nextNum++;
    		}

    		if(node.right != null) {
    			q.offer(node.right);
    			nextNum++;
    		}

    		if(curNum == count) {
    			pre = null;
    			count = nextNum;
    			curNum = 0;
    			nextNum = 0;
    		}

    	}while(!q.isEmpty());
    }
}
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

	Queue<Integer> q;
	List<List<Integer>> nums;
	ArrayList<Integer> counts;
    public List<List<Integer>> levelOrder(TreeNode root) {
        q = new LinkedList<Integer>();
        nums = new ArrayList<List<Integer>>();
        counts = new ArrayList<Integer>();

        if(root == null)
        	return nums;

        q.offer(root.val);
        counts.add(1);

        add(root, 1);

        for(int i=0; i<counts.size(); i++) {
        	ArrayList<Integer> num = new ArrayList<Integer>();

        	int len = counts.get(i);
        	for(int j=0; j<len; j++) {
        		int val = q.poll();
        		num.add(val);	
        	}
        	nums.add(num);
        }

        return nums;

    }

    public void add(TreeNode n, int level) {

    	if(n.left != null) {
    		int len = counts.size();
    		if(level >= len) {
    			counts.add(1);
    		} else {
    			int count = counts.get(level);
    			counts.set(level, count+1);
    		}
    		q.offer(n.left.val);
    		
    	}

    	if(n.right != null) {
    		int len = counts.size();
    		if(level >= len) {
    			counts.add(1);
    		} else {
    			int count = counts.get(level);
    			counts.set(level, count+1);
    		}
    		q.offer(n.right.val);
    		
    	}

    	if(n.left != null)
    		add(n.left, level+1);
    	if(n.right != null)
    		add(n.right, level+1);
    }
}






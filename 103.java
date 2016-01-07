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

	Stack<TreeNode> s1;
	Stack<TreeNode> s2;
	List<List<Integer>> nums;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        nums = new ArrayList<List<Integer>>();

        if(root == null) 
        	return nums;

        s1 = new Stack<TreeNode>();
        S2 = new Stack<TreeNode>();
        

        List<Integer> num = new ArrayList<Integer>();

        s1.push(root);
        int type = 0;

        int count = 1;
        int curNum = 0;
        int nextNum = 0;

        do {

        	curNum ++;

    		TreeNode temp; 

    		if(type == 0) {
    			temp = s1.pop();

	    		if(temp.left != null) {
	    			s.push(temp.left);
	    			nextNum ++;
	    		}
	    		if(temp.right != null) {
	    			s.push(temp.right);
	    			nextNum ++;
	    		}
	    	} else {
	    		temp = s2.pop();

	    		if(temp.right != null) {
	    			s.push(temp.right);
	    			nextNum ++;
	    		}
	    		if(temp.left != null) {
	    			s.push(temp.left);
	    			nextNum ++;
	    		}
	    	}

    		num.add(temp.val);

        	if(count == curNum) {

        		ArrayList<Integer> tempNum = new ArrayList<Integer>(num);
        		nums.add(tempNum);
        		num.clear();

        		curNum = 0;
        		count = nextNum;
        		nextNum = 0;

        		type = 1 - type;
        	}

        } while(!s1.isEmpty() && !s2.isEmpty());

        return nums;
    }
}
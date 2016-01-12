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

	ArrayList<Integer> nums;

    public int sumNumbers(TreeNode root) {
        
        if(root == null)
        	return 0;

        nums = new ArrayList<Integer>();

        add(root, 0);

    }

    public void add(TreeNode node, int num) {

    	int val = num*10+node.val;

    	if(node.left == null && node.right == null) {
    		nums.add(val);
    	}

    	if(node.left != null) {
    		add(node.left, val);
    	}

    	if(node.right != null) {
    		add(node.right, val);
    	}
    }
}








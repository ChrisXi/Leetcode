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
    public boolean hasPathSum(TreeNode root, int sum) {
        
        if(root == null)
        	return false;

        return check(root, sum);
    }

    public boolean check(TreeNode node, int sum) {

    	boolean left = false;
    	boolean right = false;

    	if(node.left == null && node.right == null) {
    		
    		if(sum-node.val == 0)
    			return true;

    		return false;
    	}

    	if(node.left != null) 
			left = check(node.left, sum-node.val);
		if(node.right != null)
    		right = check(node.right, sum-node.val);


    	return left||right;
    }
}
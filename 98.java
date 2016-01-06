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
    public boolean isValidBST(TreeNode root) {
        
        if(root == null)
        	return true;

		return check(root, null, null);
        

    }

	public boolean check(TreeNode node, TreeNode min, TreeNode max) {

		boolean left = true;
        boolean right = true;

        if(node.left != null) {

        	if((min != null && node.left.val <= min.val) || node.left.val >= node.val) {
        		return false;
        	}

        	left=check(node.left, min, node);
        }

        if(node.right != null) {
        	if(node.right.val <= node.val || (max != null && node.right.val >= max.val)) {
        		return false;
        	}

			right=check(node.right, node, max);
        }

		return left&&right;
        
		

	}
}
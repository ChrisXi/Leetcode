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

        boolean left = true;
        boolean right = true;

        if(root.left != null) {

        	if(left.val > root.val)
        		return false;

        	left=check(root.left, null, root);
        }
        if(root.right != null) {
        	if(right.val < root.val)
        		return false;

			right=check(root.right, root, null);
        }

		return left&&right;
        

    }

	public boolean check(TreeNode node, TreeNode min, TreeNode max) {

		boolean left = true;
        boolean right = true;

        if(node.left != null)
        	left=check(root.left, null, root);
        if(root.right != null)
			right=check(root.right, root, null);

		return left&&right;
		

	}
}
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
    public boolean isBalanced(TreeNode root) {
        
    }

    public int depth(TreeNode node) {

    	if(node == null)
    		return 0;

    	int left = depth(root.left);
    	int right = depth(root.right);

    	if(left == -1 || right == -1)
    		return -1;


    	if(abs(left-right) <= 1)
    		return Math.max(left, right)+1;

    	return -1;
    }
}
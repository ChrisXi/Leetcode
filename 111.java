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
    public int minDepth(TreeNode root) {
        
        

        return depth(root);
    }

    public int depth(TreeNode node) {
    	if(node == null)
    		return 0;

    	int left = depth(node.left)+1;
    	int right = depth(node.right)+1;

    	int max = Math.max(left,right);
    	int min = Math.min(left,right);

    	if(min == 1)
    		return max;

    	return left<right ? left:right;
    }
}
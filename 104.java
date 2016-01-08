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


    public int maxDepth(TreeNode root) {
        
        if(root == null)
        	return 0;


        return search(root);
    }

    public int search(TreeNode node) {

    	if(node == null)
    		return 0; 

    	int leftDepth = search(node.left)+1;
    	int rightDepth = search(node.right)+1;

    	return leftDepth>=rightDepth ? leftDepth:rightDepth;
    }

}



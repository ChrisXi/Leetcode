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
    public void flatten(TreeNode root) {
        
        if(root == null) 
        	return root;

        getNode(root);

        return root;
    }

    public TreeNode getNode(TreeNode node) {

    	if(node.right == null && node.left == null)
    		return node;

    	TreeNode leafRight = null;
    	TreeNode leafLeft = null;

    	if(node.right != null) {
    		leafRight = getNode(node.right);
    	}

    	if(node.left != null) {
    		leafLeft = getNode(node.left);
    	}

    	if(leafLeft != null) {
    		if(leafRight != null) {	

    			leafLeft.right = node.right;
    			node.right = node.left;

    			return leafRight;
    		} else {

    			node.right = node.left;

    			return leafLeft;
    		}
    	}

    	return leafRight;

    }
}
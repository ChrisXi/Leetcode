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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nums = new ArrayList<Integer>();

        if(root == null)
        	return nums;

        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);

        while(!s.isEmtpy()) {
        	TreeNode n = s.pop();

        	nums.add(n.val);

        	if(n.left != null) {
        		s.push(n.left);
        	}

        	if(n.right != null) {
        		s.push(n.right);
        	}

        }
    }
}
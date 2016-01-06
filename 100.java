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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        return check(p, q);
    }
      
    public boolean check(TreeNode p, TreeNode q) {
        
        if(p == null & q == null)
            return true;
        
        if((p == null && q != null) ||
           (q == null && p != null) ||
           (p.val != q.val)) {
        	
        	return false;       
        }
        
        return (p.val == q.val)&&check(p.left, q.left)&&check(p.right, q.right);
    }
}
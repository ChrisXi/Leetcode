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

    List<List<Integer>> paths;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        paths = new ArrayList<List<Integer>>();

        ArrayList<Integer> path = new ArrayList<Integer>();

        if(root == null)
            return paths;

        add(root, path, sum);

        return paths;
    }

    public void add(TreeNode node, ArrayList path, int sum) {

        boolean left = false;
        boolean right = false;

        ArrayList<Integer> temp = new ArrayList(path);

        temp.add(node.val);

        if(node.left == null && node.right == null) {
            
            if(sum-node.val == 0) {
                paths.add(temp);
            }
        }


        if(node.left != null) 
            add(node.left, temp, sum-node.val);
        if(node.right != null)
            add(node.right, temp, sum-node.val);

    }
}
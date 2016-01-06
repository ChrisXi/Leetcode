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

	Queue<TreeNode> q;
	List<List<Integer>> nums;
    public List<List<Integer>> levelOrder(TreeNode root) {
        q = new LinkedList<TreeNode>();
        nums = new ArrayList<List<Integer>>();

        if(root == null)
        	return nums;

        q.offer(root);
        
        int count = 1;
        int nodeNum = 0;
        int nextCount = 0;
        ArrayList<Integer> num = new ArrayList<Integer>();
        while(!q.isEmpty()) {

            nodeNum ++;

            TreeNode temp = q.poll();
            num.add(temp.val);

            if(temp.left != null) {
                q.offer(temp.left);
                nextCount ++;
            }

            if(temp.right != null) {
                q.offer(temp.right);
                nextCount ++;
            }

            if(count == nodeNum) {
                ArrayList<Integer> n = new ArrayList<Integer>(num);
                nums.add(n);
                num.clear();
                count = nextCount;
                nextCount = 0;
                nodeNum = 0;
            }

        }

        return nums;

    }

   
}






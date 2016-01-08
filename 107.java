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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        List<List<Integer>> nums = new ArrayList<List<Integer>>();
        ArrayList<Integer> num = new ArrayList<Integer>();

        if(root == null) 
        	return nums;

        q.offer(root);

        int count = 1;
        int curNum = 0;
        int nextNum = 0;

        do {

        	curNum ++;

        	TreeNode node = q.poll();
        	num.add(node.val);

        	if(node.left != null) {
        		q.offer(node.left);
        		nextNum ++;
        	}

        	if(node.right != null) {
        		q.offer(node.right);
        		nextNum ++;
        	}

        	if(count == curNum) {
        		count = nextNum;
        		curNum = 0;
        		nextNum = 0;
        		ArrayList<Integer> temp = new ArrayList<Integer>(num);
        		nums.add(0,temp);
        		num.clear();
        	}

        }while(!q.isEmpty());

        return nums;
    }
}



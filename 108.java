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

    public TreeNode sortedArrayToBST(int[] nums) {
    	
    	int len = nums.length;

    	return addChild(nums, 0, len-1);
    }

    public TreeNode addChild(int[] nums, int s, int e) {

    	if(s>e) {
    		return null;
    	}

    	if(s == e) {
    		return new TreeNode(nums[s]);
    	}

    	int index = (e+s)/2;
    	TreeNode node = new TreeNode(nums[index]);

    	node.left = addChild(nums, s, index-1);
    	node.right = addChild(nums, index+1, e);

    	return node;
    }
}



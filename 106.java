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

	int[] postorder;
	int[] inorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder.clone();
        this.inorder = inorder.clone();

        int len = postorder.length;

        return build(0, len-1, 0, len-1);

    }

    public TreeNode build(int s1, int e1, int s2, int e2) {

    	if(s2>e2)
    		return null;

    	if(s2 == e2)
    		return new TreeNode(this.inorder[s2]);

    	int val = this.postorder[e1];
    	int index = findNode(val,s2,e2);

    	int leftLen = index-s2;
    	int rightLen = e2-index;

    	TreeNode node = new TreeNode(val);

    	node.left = build(s1, s1+leftLen-1, s2, index-1);
    	node.right = build(s1+leftLen, e1-1, index+1, e2);

    	return node;
    }

    public int findNode(int val, int s, int e) {
    	for(int i=s; i<=e; i++) {
    		if(val == this.inorder[i]) {
    			return i;
    		}
    	}

    	return 0;
    }
}

/**
[0,1,2,3,4,5,6,7,8,9,10]
[0,2,4,6,5,3,1,8,10,9,7]
*/
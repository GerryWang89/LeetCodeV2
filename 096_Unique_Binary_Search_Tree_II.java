/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        if( n == 0){
            ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
            ret.add(null);
            return ret;
        }
        return generateBST(1, n);
    }

	public ArrayList<TreeNode> generateBST(int start, int end){
		ArrayList<TreeNode> itRet = new ArrayList<TreeNode>();
        if (start == end) {
        	itRet.add(new TreeNode(start));
            return itRet;
        }
        if (start > end) {
            itRet.add(null);
            return itRet;
        }
        for(int i = start; i <= end; i++){
        	ArrayList<TreeNode> leftTrees = generateBST(start,i-1);
            ArrayList<TreeNode> rightTrees = generateBST(i+1,end);
            for(int j = 0; j < leftTrees.size(); j++){
            	for(int k = 0; k <rightTrees.size(); k++){
            		TreeNode pivot = new TreeNode(i);
            		pivot.left = leftTrees.get(j);
            		pivot.right = rightTrees.get(k);
            		itRet.add(pivot);
            	}
            }
        }
        return itRet;
    }
}
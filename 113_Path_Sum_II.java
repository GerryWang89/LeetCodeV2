public class Solution {
    private ArrayList<ArrayList<Integer>> ret;
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ret = new ArrayList<ArrayList<Integer>>();
        solve(root, sum, new ArrayList<Integer>());
        return ret;
    }
    
    public void solve(TreeNode root, int sum, ArrayList<Integer> cur){
        if (root == null) 
            return;
        if (root.left == null && root.right == null){
            if (sum == root.val){
                cur.add(root.val);
                ret.add(new ArrayList<Integer>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        cur.add(root.val);
        solve(root.left, sum - root.val, cur);
        solve(root.right, sum - root.val, cur);
        cur.remove(cur.size() - 1);
    }
}
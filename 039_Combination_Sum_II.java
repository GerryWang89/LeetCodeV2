public class Solution {
    private ArrayList<ArrayList<Integer>> ret;
    
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        solve(candidates, target, 0, new ArrayList<Integer>());
        return ret;
    }
    
    private void solve(int[] candidates, int target, int index, ArrayList<Integer> cur){
        if (target == 0) {
            ret.add(new ArrayList<Integer>(cur));
            return;
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            solve(candidates, target - candidates[i], i + 1, cur);
            cur.remove(cur.size() - 1);
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }
}
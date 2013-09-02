public class Solution {
    private ArrayList<ArrayList<Integer>> ret;
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ret = new ArrayList<ArrayList<Integer>>();
        solve(1, n, k, new ArrayList<Integer>());
        return ret;
    }
    
    public void solve(int base, int n, int k, ArrayList<Integer> cur){
        if (k <= 0){
            ret.add(new ArrayList<Integer>(cur));
            return;
        }
        if (n - base + 1 < k) 
            return;
        for (int i = base; i <= n; i++) {
            cur.add(i);
            solve(i + 1, n, k - 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
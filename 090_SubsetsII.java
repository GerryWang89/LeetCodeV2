public class Solution { 
    private ArrayList<ArrayList<Integer>> ret;
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        Arrays.sort(S);
        ret = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= S.length; i++) {
            solve(S, i, 0, new ArrayList<Integer>());
        }
        return ret;
    }
    
    private void solve(int[] S, int k, int base, ArrayList<Integer> cur){
        if (k <= 0) {
            ret.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = base; i < S.length; i++) {
            cur.add(S[i]);
            solve(S, k - 1, i + 1, cur);
            cur.remove(cur.size() - 1);
            while (i < S.length - 1 && S[i] == S[i + 1]) {
                i++;
            }
        }
    }
}
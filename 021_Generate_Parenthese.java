public class Solution {
    ArrayList<String> ret;
    public ArrayList<String> generateParenthesis(int n) {
        ret = new ArrayList<String>();
        solve("",n,n);
        return ret;
    }
    
    public void solve(String cur, int left, int right){
        if(right < left)
            return;
        if(right == left && right == 0){
            ret.add(cur);
            return;
        }
        if(left > 0){
            cur += "(";
            solve(cur, left - 1, right);
            cur = cur.substring(0,cur.length() - 1);
        }
        if(right > 0){
            cur += ")";
            solve(cur, left, right - 1);
            cur = cur.substring(0,cur.length() - 1);
        }
    }
}
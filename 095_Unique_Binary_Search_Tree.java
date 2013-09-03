public class Solution {
    private int[] v;
    
    public int numTrees(int n) {
        if ( n == 0 || n == 1)
            return 1;
        v = new int[n + 1];
        v[0] = 1;
        v[1] = 1;
        return solve(n);
    }
    
    public int solve(int n){
        if ( n == 0 || n == 1)
            return 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (v[i - 1] == 0)
                v[i - 1] = solve(i - 1);
            if (v[n - i] == 0)
                v[n - i] = solve(n - i);
            sum += v[i - 1] * v[n - i];
        }
        return sum;
    }
}
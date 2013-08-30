public class Solution {
    public int reverse(int x) {
    	if(x == 0) return 0;
        
        int a = x, y = 0, b=Math.abs(x);
        x = Math.abs(x);
        while(x != 0)
        {
            y *= 10;
            y += x%10;
            x /= 10;
        }
        return (a/b)*y;
    }
}
public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, base = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < base){
                base = prices[i];
            }else if( prices[i] > base){
                if(prices[i] - base > max){
                    max = prices[i] - base;
                }
            }
        }
        return max;
    }
}
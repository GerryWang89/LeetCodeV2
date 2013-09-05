public class Solution {
    public int maxProfit(int[] prices) {
        int curBuy = -1,sum = 0;
        for(int i = 0; i < prices.length-1; i++){
            if(prices[i+1] < prices[i]){
                if(curBuy != -1){
                    sum += prices[i] - curBuy;
                    curBuy = -1;
                }
            }
            if(prices[i+1] > prices[i]){
                if(curBuy == -1)
                    curBuy = prices[i];
            }
        }
        if(curBuy != -1)
            sum += prices[prices.length-1] - curBuy;
        return sum;
    }
}
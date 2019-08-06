package main.java.ChinaHadoop_AI_Offer.DynamicProgramming.day19;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {
    /**
     *dp算法：状态量dp[i]表示到第i天为止股价最低值，然后计算到第i天的最大利润profit[i]=prices[i]-dp[i]，得到最大值
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            if(prices[i]-min>maxProfit){
                maxProfit=prices[i]-min;
            }
        }
        return maxProfit;
    }
}

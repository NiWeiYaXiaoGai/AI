package main.java.ChinaHadoop_AI_Offer.DynamicProgramming.day19;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        /**
         * https://leetcode.com/problems/min-cost-climbing-stairs/submissions/
         *dp算法：状态量dp(i)表示到达第i阶楼梯的花费，因此dp[i+1]为爬完i+1阶楼梯的最小花费
         * 状态转移方程：dp[i]=min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
         * 时间复杂度O(n)
         * 空间复杂度O(n)
         */
        int[] dp=new int[cost.length+1];
        for(int i=2;i<=cost.length;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }
}

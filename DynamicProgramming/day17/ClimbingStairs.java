package main.java.ChinaHadoop_AI_Offer.DynamicProgramming.day17;

public class ClimbingStairs {
    public int climbStairs(int n) {
        /**
         * https://leetcode.com/problems/climbing-stairs/submissions/
         *dp算法，状态变量dp(n)表示台阶数为n的阶梯的攀登方法，状态转移方程为dp(n)=dp(n-1)+dp(n-2)
         * 时间复杂度O(n)
         * 空间复杂度O(n)
         */
        if(n<=2)
            return n;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}

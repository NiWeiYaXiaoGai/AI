package main.java.ChinaHadoop_AI_Offer.DynamicProgramming.day19;

public class HouseRobber {
    /**
     * https://leetcode.com/problems/house-robber/
     *dp算法：dp[i]表示i家银行的抢劫的最大金额
     * 状态转移方程：dp[i]=max(dp[i-1],dp[i-2]+nums[i])
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int[] dp=new int[nums.length+1];
        dp[1]=nums[0];
        for(int i=2;i<=nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];
    }


}

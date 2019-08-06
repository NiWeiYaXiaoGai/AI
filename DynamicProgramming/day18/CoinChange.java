package main.java.ChinaHadoop_AI_Offer.DynamicProgramming.day18;

public class CoinChange {
    /**
     *https://leetcode.com/problems/coin-change/submissions/
     */
    public static int coinChange(int[] coins, int amount) {
        /**
         * dp算法：状态量dp(i)表示金额为i时最少的纸币数量，状态转移方程
         *        dp(i)=min(dp(i-1),dp(i-2),dp(i-5))+1
         *  时间复杂度O(n)
         *  空间复杂度O(n)
         */
        int[] dp=new int[amount+1];
        for(int i=1;i<=amount;i++){
            dp[i]=-1;
        }
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0 && dp[i-coins[j]]!=-1){  //表示金额为i的时候可以兑换成功
                    if(dp[i]==-1 || dp[i]>dp[i-coins[j]]+1){
                        dp[i]=dp[i-coins[j]]+1;
                    }

                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins={1,2,5};
        int amount=11;
        coinChange(coins,amount);
    }
}

package main.java.ChinaHadoop_AI_Offer.DynamicProgramming.day18;

/**
 * https://leetcode.com/problems/coin-change-2/
 */
public class CoinChange2 {
    /**
     * https://leetcode.com/problems/coin-change-2/
     * https://blog.csdn.net/grllery/article/details/88535349
     * dp算法，状态量dp[i][j]中的i表示前i种硬币，j表示金额数量
     * 对于第i个硬币，存在两种状态，使用或者不使用
     * 若不使用，dp[i][j]=dp[i-1][j]
     * 若使用，dp[i][j]=j>=coins[i]?dp[i][j-coin[i]]：0
     * 状态转移方程：
     * dp[i][j]=dp[i-1][j]+j>coins[i]?dp[i][j-coin[i]]：0
     * 时间复杂度O(m*n)  m为硬币数量，n为金额数量
     * 空间复杂度O(m*n)  m为硬币数量，n为金额数量
     */
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length+1][amount+1];
        dp[0][0]=1;
        for(int i=1;i<=coins.length;i++){
            for(int j=0;j<=amount;j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}

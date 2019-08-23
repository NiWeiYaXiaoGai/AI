package main.java.ChinaHadoop_AI_Offer.Array.day23;

public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        /**
         * dp算法:dp[i][j]表示s的前i个字符与p的前j个字符相匹配
         * 如果p的第j个字符为*，则dp[i][j]=dp[i][j-1] || dp[i-1][j]
         * 如果p的第j个字符为?，dp[i][j]=dp[i-1][j-1]
         * 其它情况，dp[i][j]=dp[i-1][j-1] && s.charAt(i-1)==p.charAt(j-1)
         * 时间复杂度O（n）
         * 空间复杂度O（n）
         */
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        //空字符串是匹配空字符串的
        dp[0][0]=true;
        for(int j=1;j<=p.length();j++){
            dp[0][j]=dp[0][j-1] && p.charAt(j-1)=='*';
        }
        for(int i=1;i<=s.length();i++){
            dp[i][0]=false;
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-1] || dp[i-1][j-1];
                }else if(p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=dp[i-1][j-1] && s.charAt(i-1)==p.charAt(j-1);
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s="aa";
        String p="*";
        isMatch(s,p);
    }
}

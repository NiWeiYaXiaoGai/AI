package main.java.ChinaHadoop_AI_Offer.DynamicProgramming.day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0 || triangle.get(0)==null || triangle.get(0).size()==0 || triangle.get(0).get(0)==null)
            return 0;
        int temp;
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                temp=triangle.get(i).get(j);
                temp+=Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                triangle.get(i).set(j,temp);
            }
        }
        return triangle.get(0).get(0);
    }

    public static int minimumTotal2(List<List<Integer>> triangle) {
        /**
         * https://leetcode.com/problems/triangle/submissions/
         * https://www.cnblogs.com/271934Liao/p/6919843.html
         * dp算法：状态量dp[i][j]表示表示到达第i行第j个元素的最小路径值，最后返回最后一行的最小值
         * 状态转移方程：dp[i][j]=min(dp[i-1][j-1],dp[i-1][j])+triangle[i][j]
         * 时间复杂度O(n)
         * 空间复杂度O(n)
         */
        if(triangle==null || triangle.size()==0 || triangle.get(0)==null || triangle.get(0).size()==0 || triangle.get(0).get(0)==null)
            return 0;
        int[][] dp=new int[triangle.size()][triangle.size()];
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            for(int j=0;j<triangle.get(i).size();j++){
                if(j==0){
                    dp[i][j]=dp[i-1][j]+triangle.get(i).get(j);
                }else if(j==triangle.get(i).size()-1){
                    dp[i][j]=dp[i-1][j-1]+triangle.get(i).get(j);
                } else {
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<triangle.size();i++){
            if(min>dp[triangle.size()-1][i]){
                min=dp[triangle.size()-1][i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> test=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        list.add(2);
        test.add(list);
        list=new ArrayList<>();
        list.add(3);
        list.add(4);
        test.add(list);
        list=new ArrayList<>();
        list.add(6);
        list.add(5);
        list.add(7);
        test.add(list);
        list=new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(8);
        list.add(3);
        test.add(list);
        minimumTotal2(test);
    }
}

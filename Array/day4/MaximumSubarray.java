package main.java.ChinaHadoop_AI_Offer.Array.day4;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * 从左往右叠加数字，如果前一个sum为正数，则继续叠加，记录max
     * 前一个sum为负数，叠加起点跳跃至当前元素
     */
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(sum<0)
                sum=nums[i];
            else
                sum+=nums[i];
            max=sum>max?sum:max;
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray test=new MaximumSubarray();
        int[] arr={1,2};
        test.maxSubArray(arr);
    }
}

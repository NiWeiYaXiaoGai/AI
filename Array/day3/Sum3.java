package main.java.ChinaHadoop_AI_Offer.Array.day1;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 * description:Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * 时间复杂度O(n^2)
 * 空间复杂度O(1)
 * 双指针算法
 */
public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            //遍历第一个三胞胎元素的时候，如果当前元素和上一次的元素相等，直接跳过，否则结果集会重复
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int sum=0;
            while(left<right){
                sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right && nums[left]==nums[left+1]){ //left<right防止left溢出
                        left++;
                    }
                    while (left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum<0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Sum3 sum3=new Sum3();
        int[] arr={-1,0,1,2,-1,-4};
        sum3.threeSum(arr);
    }
}

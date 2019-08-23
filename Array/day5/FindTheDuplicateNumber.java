package main.java.ChinaHadoop_AI_Offer.Array.day5;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * description:
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * 二分查找，统计小于等于mid的个数，大于mid，则在区间start-mid
 * 时间复杂度O（nlog(n)）
 * 空间复杂度O(1)
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int start=1;
        int end=nums.length-1;
        int mid;
        int count;
        while(start<end){
            mid=(start+end)/2;
            count=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=mid)
                    count++;
            }
            if(count<=mid){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return start;//此时start=end
    }
}

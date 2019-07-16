package main.java.ChinaHadoop_AI_Offer.Array.day1;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int left=0;
        int right=nums.length-1;
        int medium;
        while(left<right){
            medium=(left+right)/2;
            if(medium==left && nums[medium]>nums[medium+1])
                return nums[medium+1];
            if(medium>0 && nums[medium]<nums[medium-1] && medium<nums.length-1 && nums[medium]<nums[medium+1])
                return nums[medium];
            if(nums[left]>nums[medium])
                right=medium;
            else if(nums[medium]>nums[right])
                left=medium;
            else
                right=medium;
        }
        return nums[left];
    }
}

package main.java.ChinaHadoop_AI_Offer.Array.day20;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        /**
         * 二分查找算法，由于存在重复的数，所有nums[mid]可能等于nums[end]比如[1 1 3 1]
         * 此时只要right--
         *时间复杂度O(log(n))
         *空间复杂度O(1)
         */
        if(nums==null || nums.length==0)
            return false;
        int start=0;
        int end=nums.length-1;
        int mid;
        while(start<=end){
            mid=start+(end-start)/2;
            if(target==nums[mid]){
                return true;
            }
            if(target<nums[mid]){
                if(nums[mid]>nums[end]){ //左半边有序
                    if(target<nums[start]){
                        start=mid+1;
                    }else{
                        end=mid-1;
                    }
                }else if(nums[mid]<nums[end]){ //右半边有序
                    end=mid-1;
                }else{
                    end--;
                }
            }
            if(target>nums[mid]){
                if(nums[mid]>nums[end]){ //左半边有序
                    start=mid+1;
                }else if(nums[mid]<nums[end]){ //右半边有序
                    if(target<nums[end]){
                        start=mid+1;
                    }else{
                        end=mid-1;
                    }
                }else{
                    end--;
                }
            }
        }
        return false;
    }
}

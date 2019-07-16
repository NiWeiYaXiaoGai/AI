package main.java.ChinaHadoop_AI_Offer.Array.day2;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargestImpl(nums,k,0,nums.length-1);
    }

    private int findKthLargestImpl(int[] nums,int k,int low,int high){
        int start=low;
        int end=high;
        int temp;
        while(start<end){
            while(nums[end]<=nums[low] && start<end){
                end--;
            }
            while(nums[start]>=nums[low] && start<end){
                start++;
            }
            if(start<end){
                temp= nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
            }
        }
        if(start==end){
            temp= nums[low];
            nums[low]=nums[start];
            nums[start]=temp;
        }
        if(start==k-1)
            return nums[k-1];
        if(start<k-1)
            return findKthLargestImpl(nums,k,start+1,high);
        else
            return findKthLargestImpl(nums,k,low,start-1);
    }
}

package main.java.ChinaHadoop_AI_Offer.Array.day3;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/  153
 *  时间复杂度O(log(n))
 *  *空间复杂度O(1)
 */
public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        //表示未发生旋转
        if(nums[0]<nums[nums.length-1]){
            return nums[0];
        }
        //发生旋转
        int left=0;
        int right=nums.length-1;
        int mid;
        while(left<=right){
            mid=left+(right-left)/2;
            //left不能等于mid+1，是要保证该数组在二分过程中一定是旋转数组，不然[4 5 6 1 2 3] left=mid+1 二分后的数组为[1 2 3]
            if(nums[left]<nums[mid]){
                left=mid;
            }else if(nums[left]>nums[mid]){
                right=mid;
            }else if(nums[left]==nums[mid]){
                if(mid+1<nums.length){
                    return Math.min(nums[mid],nums[mid+1]);
                }else{
                    return nums[mid];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={2,3,4,5,1};
        findMin(arr);
    }
}

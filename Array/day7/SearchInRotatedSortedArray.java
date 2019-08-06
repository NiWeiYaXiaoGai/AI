package main.java.ChinaHadoop_AI_Offer.Array.day7;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int mid=-1;
        while(start<=end){
            mid=(start+end)/2;
            if(target==nums[mid]){
                return mid;
            }
            if(target<nums[mid]){
                if(nums[start]<nums[mid]){
                    if(nums[start]<=target){
                        end=mid-1;
                    }else{
                        start=mid+1;
                    }
                }else if(nums[start]>nums[mid]){
                    if(target>=start){
                        end=mid-1;
                    }else{
                        start=mid+1;
                    }
                }else{  //nums[start]==nums[mid]
                    start=mid+1;
                }
            }
            if(target>nums[mid]){
                if(nums[start]<nums[mid]){
                    start=mid+1;
                }else if(nums[start]>nums[mid]){
                    if(target>=nums[start]){
                        end=mid-1;
                    }else{
                        start=mid+1;
                    }
                }else{  //nums[start]==nums[mid]
                    start=mid+1;
                }
            }
        }
        return -1;
    }

    public static int search2(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int mid=-1;
        while(start<=end){
            mid=start+(end-start)/2;
            if(target==nums[mid]){
                return mid;
            }
            if(target<nums[mid]){
                if(nums[start]<nums[mid]){
                    if(target<nums[start]){
                        start=mid+1;
                    }else{
                        end=mid-1;
                    }
                }else if(nums[start]>nums[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
            if(target>nums[mid]){
                if(nums[start]<nums[mid]){
                    start=mid+1;
                }else if(nums[start]>nums[mid]){
                    if(target>nums[end]){
                        end=mid-1;
                    }else{
                        start=mid+1;
                    }
                }else{
                    start=mid+1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray test=new SearchInRotatedSortedArray();
        int[] arr={5,1,2,3,4};
        test.search2(arr, 1);
    }
}

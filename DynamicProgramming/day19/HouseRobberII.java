package main.java.ChinaHadoop_AI_Offer.DynamicProgramming.day19;

public class HouseRobberII {
    /**
     * https://leetcode.com/problems/house-robber-ii/submissions/
     * https://blog.csdn.net/u012501459/article/details/46481255
     * dp算法：同上一题，有银行闭合成环，因此分成两种可能性第一家绝对不抢，最后一家绝对不抢
     * 考虑抢劫了第0个房间，那么问题就是求抢劫第0~N-1个房间的最大数。
     * 考虑不抢劫第0个房间，那么问题就是求抢劫第1~N个房间的最大数。
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        return Math.max(robImpl(nums,0,nums.length-2),robImpl(nums,1,nums.length-1));
    }
    public static int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return 0;
        int start=0;
        int end=nums.length-1;
        int mid=0;
        while(start<=end){
            mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                if(mid==0 || nums[mid-1]>target){
                    return mid;
                }else{
                    end=mid-1;
                }
            }
            if(nums[mid]<target){
                if(mid==nums.length-1 || target<nums[mid+1]){
                    return mid+1;
                }else{
                    start=mid+1;
                }
            }
        }
        return mid;
    }
    private int robImpl(int[] nums,int left,int right){
        int length=right-left+1;
        int[] dp=new int[length+1];
        dp[1]=nums[left];
        for(int i=2;i<=length;i++){
            dp[i]=Math.max(dp[i-2]+nums[left+i-1],dp[i-1]);
        }
        return dp[length];
    }

    public static void main(String[] args) {
        int[] arr={1,3,5,6};
        searchInsert(arr,0);
    }
}

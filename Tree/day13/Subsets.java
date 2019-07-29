package main.java.ChinaHadoop_AI_Offer.Tree.day13;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    /**
     * 回溯算法，遍历数组中的每一个元素然后移除
     * 时间复杂度O（2^n）
     * 空间复杂度O（2^n）
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> sub=new ArrayList<>();
        backTrack(res,sub,nums,0,nums.length);
        return res;
    }

    private void backTrack(List<List<Integer>> res,List<Integer> sub,int[] nums,int k,int target){
        if(k==target){
            res.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[k]);
        backTrack(res,sub,nums,k+1,target);
        sub.remove(sub.size()-1);
        backTrack(res,sub,nums,k+1,target);
    }

    public static void main(String[] args) {
        int[] arr={1,2,3};
        new Subsets().subsets(arr);
    }
}

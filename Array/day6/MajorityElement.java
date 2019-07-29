package main.java.ChinaHadoop_AI_Offer.Array.day4;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {
    /**
     *使用散列表来统计每个元素出现的频次
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int majCount=0;
        int majority=nums[0];
        int count;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                count=map.get(nums[i])+1;
                map.put(nums[i],count);
                if(count>majCount){
                    majority=nums[i];
                    majCount=count;
                }
            }else{
                map.put(nums[i],1);
                if(majCount<1){
                    majority=nums[i];
                    majCount=1;
                }
            }
        }
        return majority;
    }
}

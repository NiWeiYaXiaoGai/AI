package main.java.ChinaHadoop_AI_Offer.Array.day3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    //1.暴力解决
    public List<Integer> countSmaller(int[] nums) {
        int count;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            count=0;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j])
                    count++;
            }
            list.add(new Integer(count));
        }
        return list;
    }

    //2.二分搜索算法
    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> sort=new LinkedList<>();
        List<Integer> res=new LinkedList<>();
        for(int i=nums.length-1;i>=0;i--){
            int start=0;
            int end=sort.size()-1;
            int mid;
            if(i==nums.length-1){
                sort.add(nums[i]);
                res.add(0);
            }
            while(start<=end){
                mid=start+(end-start)/2;
                if(nums[i]==sort.get(mid)){
                    sort.add(mid,nums[i]);
                    res.add(0,mid);
                    break;
                }

                if(nums[i]<sort.get(mid)){
                    if(mid>0 && nums[i]>sort.get(mid-1)){
                        sort.add(mid,nums[i]);
                        res.add(0,mid);
                        break;
                    }else if(mid==0){
                        sort.add(0,nums[i]);
                        res.add(0,0);
                        break;
                    }else{
                        end=mid-1;
                    }
                }
                if(nums[i]>sort.get(mid)){
                    if(mid<sort.size()-1 && nums[i]<sort.get(mid+1)){
                        sort.add(mid+1,nums[i]);
                        res.add(0,mid+1);
                        break;
                    }else if(mid==sort.size()-1){
                        sort.add(mid+1,nums[i]);
                        res.add(0,mid+1);
                        break;
                    }else{
                        start=mid+1;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        CountOfSmallerNumbersAfterSelf test=new CountOfSmallerNumbersAfterSelf();
        int[] arr={26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        test.countSmaller2(arr);
        System.out.println();
    }
}

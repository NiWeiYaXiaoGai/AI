package main.java.ChinaHadoop_AI_Offer.Array.day20;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        /**
         * 二分搜索+滑动窗口算法
         * 取长度为k的窗口，窗口的左指针的移动区间在[0，length-k],比较窗口中最小的数与落在窗口外部
         * 小的数到x的距离，小于等于窗口向左滑动（因为取较小的数），大于往右滑动，直到移动区间为0
         * 时间复杂度O(log(n))
         * 空间复杂度O(k)
         */
        int start=0;
        int end=arr.length-k;
        int mid;
        while(start<end){
            mid=start+(end-start)/2;
            if(x-arr[mid]>arr[mid+k]-x){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int i=start;i<start+k;i++){
            res.add(arr[i]);
        }
       return res;
    }

    public static void main(String[] args) {
       int[] arr={1,2,3,4,5};
       findClosestElements(arr,4,-1);
    }
}

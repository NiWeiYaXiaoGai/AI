package main.java.ChinaHadoop_AI_Offer.Array.day24;

import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        /**
         * 先对intervals进行排序，然后比较左右端点，注意list与二维数组之间的转换
         * 时间复杂度O（nlog(n)）
         * 空间复杂度O（n）
         */
        if(intervals==null || intervals.length<=1)
            return intervals;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> list= new LinkedList<>(Arrays.asList(intervals));
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)[1]>=list.get(i+1)[0]){
                if(list.get(i)[1]<list.get(i+1)[1]){
                    list.get(i)[1]=list.get(i+1)[1];
                }
                list.remove(i+1);
                i--;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr={{1,3},{2,6},{8,10},{15,18}};
        merge(arr);

    }
}

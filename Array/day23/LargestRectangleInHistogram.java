package main.java.ChinaHadoop_AI_Offer.Array.day23;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        /**
         * 解题思路：暴力遍历每一根柱子，找出左边和右边第一根比它小的柱子坐标,
         * 分别求出包含每个柱子的矩形区域的最大面积，然后选最大的
         *dp算法优化， leftLessMin[i]表示在i的左边第一根比i小的柱子坐标，
         * 当前柱子 i 比上一个柱子小的时候，可以直接跳跃至leftLessMin[ i - 1]，也就是第一个比上个柱子小的柱子，
         * 如果leftLessMin[ i - 1]<heights[i],leftLessMin[i]=leftLessMin[ i - 1]+1,否则嵌套循环
         * 时间复杂度O（n）
         * 空间复杂度O（n）
         */
        int max=0;
        if(heights==null || heights.length==0)
            return max;
        int[] leftLessMin=new int[heights.length];
        leftLessMin[0]=-1;
        int left;

        //求出i左边第一个比它小的元素
        for(int i=1;i<heights.length;i++){
            left=i-1;
            while(left>=0 &&heights[left]>=heights[i]){
                left=leftLessMin[left];
            }
            leftLessMin[i]=left;
        }

        //求出i右边第一个第它小的元素
        int[] rightLessMin=new int[heights.length];
        rightLessMin[heights.length-1]=heights.length;
        int right;
        for(int i=heights.length-2;i>=0;i--){
            right=i+1;
            while (right<heights.length && heights[right]>=heights[i]){
                right=rightLessMin[right];
            }
            rightLessMin[i]=right;
        }

        //遍历每一根柱子，求出最大面积

        for(int i=0;i<heights.length;i++){
            if(max<(rightLessMin[i]-leftLessMin[i]-1)*heights[i]){
                max=(rightLessMin[i]-leftLessMin[i]-1)*heights[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr={2,1,5,6,2,3};
        largestRectangleArea(arr);
    }
}

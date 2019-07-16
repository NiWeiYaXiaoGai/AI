package main.java.ChinaHadoop_AI_Offer.Array.day2;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * 二分查找 将二维数组看成一维
 * 时间复杂度O(log(mn))
 * 空间复杂度O(1)
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;
        int rows=matrix.length;
        int cols=matrix[0].length;
        if(target<matrix[0][0] || target>matrix[rows-1][cols-1])
            return false;
        int start=0;
        int end=rows*cols-1;
        int medium;
        while(start<=end){
            medium=(start+end)/2;
            if(target==matrix[medium/cols][medium%cols])
                return true;
            if(target<matrix[medium/cols][medium%cols])
                end=medium-1;
            if(target>matrix[medium/cols][medium%cols])
                start=medium+1;
        }
        if(start>end)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        int[][] mat={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        SearchA2DMatrix test=new SearchA2DMatrix();
        test.searchMatrix(mat,3);
    }
}

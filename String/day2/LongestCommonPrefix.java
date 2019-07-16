package main.java.ChinaHadoop_AI_Offer.String.day2;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * description:Write a function to find the longest common prefix string amongst an array of strings.
 *             If there is no common prefix, return an empty string "".
 *  时间复杂度：O（m*n）m为字符串的长度  n为字符串数组个数
 *  空间复杂度：O(1)
 */
public class LongestCommonPrefix {
    private int minLength(String[] strs){
        int min=strs[0].length();
        for(int i=1;i<strs.length;i++){
            if(min>strs[i].length())
                min=strs[i].length();
        }
        return min;
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0)
            return "";
        StringBuilder prefix=new StringBuilder();
        boolean flag=true;
        //1.先求出数组中字符串长度的最小值
        //2.循环比较数组中每一个字符串中的字符是否相等，全部相等添加至StringBuilder中
        out:
        for(int i=0;i<minLength(strs);i++){
            char pre=strs[0].charAt(i);
            for(int j=0;j<strs.length;j++){
                if(strs[j].charAt(i)!=pre)
                    break out;
            }
            prefix.append(pre);
        }
        return prefix.toString();
    }
}

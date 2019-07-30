package main.java.ChinaHadoop_AI_Offer.String.day1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/buddy-strings/submissions/
 * description:给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 * 散列表算法
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if(A.length()!= B.length() || A.length()<2)
            return false;
        //两个字符串相等的情况
        if (A.equals(B)) {
            int[] count=new int[26];
            //任意一个字符出现两次，即可交换成功
            for(int i=0;i< A.length();i++){
                count[A.charAt(i)-'a']++;
                if(count[A.charAt(i)-'a']>=2)
                    return true;
            }
        }
        //两个字符串不相等的情况
        List<Integer> index=new ArrayList<>();
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)!= B.charAt(i))
                index.add(new Integer(i));
        }
        if(index.size()!=2)
            return false;
        if(A.charAt(index.get(0))!= B.charAt(index.get(1)) || A.charAt(index.get(1))!= B.charAt(index.get(0)))
            return false;
        return true;
    }
}

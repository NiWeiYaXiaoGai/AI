package main.java.ChinaHadoop_AI_Offer.String.day16;

import sun.security.util.Length;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class PermutationInString {
    /**
     * https://www.cnblogs.com/grandyang/p/6815227.html?utm_source=itdadao&utm_medium=referral
     *滑动窗口（双指针的一种）+散列表算法，两个哈希表存储s1长度的字符集合，然后步长为1的比较
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public static boolean checkInclusion(String s1, String s2) {
        if(s1==null || s2==null || s1.length()>s2.length())
            return false;
        Map<Character,Integer> map1=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();
        char key;
        int count;
        for(int i=0;i<s1.length();i++){
            key=s1.charAt(i);
            if(map1.containsKey(key)){
                count=map1.get(key);
                map1.put(key,++count);
            }else {
                map1.put(key,1);
            }
            key=s2.charAt(i);
            if(map2.containsKey(key)){
                count=map2.get(key);
                map2.put(key,++count);
            }else {
                map2.put(key,1);
            }
        }
        for(int i=0;i+s1.length()<s2.length();i++){
            if (map2.equals(map1)) {
                return true;
            }else{
                key=s2.charAt(i);
                count=map2.get(key);
                if(count>1){
                    map2.put(key,--count);
                }else {
                    map2.remove(key);
                }

                key=s2.charAt(s1.length()+i);
                if(map2.containsKey(key)){
                    count=map2.get(key);
                    map2.put(key,++count);
                }else {
                    map2.put(key,1);
                }

            }
        }
        if (map2.equals(map1))
            return true;
        return false;
    }

    public static boolean checkInclusion2(String s1, String s2) {
        /**
         * https://www.cnblogs.com/grandyang/p/6815227.html?utm_source=itdadao&utm_medium=referral
         *滑动窗口+散列表算法，两个哈希表存储s1长度的字符集合，然后步长为1的比较
         * 时间复杂度O(n)
         * 空间复杂度O(n)
         */
        if(s1==null || s2==null || s1.length()>s2.length())
            return false;
        int[] hashMap1=new int[26];
        int[] hashMap2=new int[26];
        for(int i=0;i<s1.length();i++){
            hashMap1[s1.charAt(i)-'a']++;
            hashMap2[s2.charAt(i)-'a']++;
        }
        for(int i=0;i+s1.length()<s2.length();i++){
            if (Arrays.equals(hashMap1, hashMap2)) {
                return true;
            }else{
                hashMap2[s2.charAt(i)-'a']--; //i是窗口滑动一格前的左边界
                hashMap2[s2.charAt(i+ s1.length())-'a']++;//i+ s1.length()是窗口滑动一格后的右边界
            }
        }
        //循环后最后一个字符还没有比较
        if (Arrays.equals(hashMap1, hashMap2)) {
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {
        checkInclusion2("ab","eidbaooo");
    }
}

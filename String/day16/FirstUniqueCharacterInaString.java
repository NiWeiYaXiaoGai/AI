package main.java.ChinaHadoop_AI_Offer.String.day16;

public class FirstUniqueCharacterInaString {
    /**
     * 散列表思想，先统计每个字符出现频次，然后遍历字符串，寻找第一个频数为1的字符
     * 时间复杂度O(Math.min(m,n))
     * 空间复杂度O(1)
     */
    public int firstUniqChar(String s) {
        if(s==null || s.isEmpty())
            return -1;
        int[] hashTable=new int[26];
        //统计字符串中每个字符出现的次数
        for(int i=0;i<s.length();i++){
            hashTable[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(hashTable[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
}

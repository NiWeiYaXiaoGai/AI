package main.java.ChinaHadoop_AI_Offer.String.day16;

/**
 * https://leetcode.com/problems/minimum-window-substring/submissions/
 * https://www.cnblogs.com/grandyang/p/4340948.html
 * 通常对于字符串类型的题目而言，不讲排列顺序通常会用到散列表
 * 滑动窗口+散列表算法，首先遍历s,统计各字母频数，散列表范围在A—Z a-z,总共58，出现的字母加1，然后滑动窗口遍历t，左边界为0，
 * 然后统计t的频数，当右指针指向的字符减1，大于等于0表示该字符在源字符串，count加1，当count==s.length()时候，表示滑动窗口内的
 * 子字符串包含源字符串的所有字符，此为向右扩张，然后左边界开始收缩，每遍历一个字符，哈希表对应位置+1，如果结果大于0，表示该字符属于
 * 目标字符串，并已经移走，而且是最后一个字符
 */
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        /**
         * https://leetcode.com/problems/minimum-window-substring/submissions/
         * https://www.cnblogs.com/grandyang/p/4340948.html
         * 通常对于字符串类型的题目而言，不讲排列顺序通常会用到散列表
         * 滑动窗口+散列表算法，首先遍历s,统计各字母频数，散列表范围在A—Z a-z,总共58，出现的字母加1，然后滑动窗口遍历t，左边界为0，
         * 然后统计t的频数，当右指针指向的字符减1，大于等于0表示该字符在源字符串，count加1，当count==s.length()时候，表示滑动窗口内的
         * 子字符串包含源字符串的所有字符，此为向右扩张，然后左边界开始收缩，每遍历一个字符，哈希表对应位置+1，如果结果大于0，表示该字符属于
         * 目标字符串，并已经移走，而且是最后一个字符
         * 时间复杂度O(n)
         * 空间复杂度O(n)
         */
//        大写字母A-Z的ASCII码为：65-90；
//        小写字母a-z的ASCII码为：97-122；
        String res="";
        if(s==null || t==null || s.length()>t.length())
            return res;
        int[] hashTable=new int[58];
        //统计源字符串各字符出现频次
        for(int i=0;i<s.length();i++){
            hashTable[s.charAt(i)-'A']++;
        }
        int left=0;
        //设置结果字符串的长度为整型最大值
        int max=Integer.MAX_VALUE;
        int count=0;
        for(int i=0;i<t.length();i++){ //移动右指针，右边界扩张
            hashTable[t.charAt(i)-'A']--;
            if(hashTable[t.charAt(i)-'A']>=0){
                count++;
            }
            //移动左指针
            while(count==s.length()){ //移动左指针，左边界收缩
                if(max>i-left+1){
                    max=i-left+1;
                    res=t.substring(left,i+1);//i为右边界指针，左闭右开，所以加1
                }

                if(++hashTable[t.charAt(left)-'A']>0){ //代表T中有字符被完全移除
                    count--;
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        minWindow("ABC","ADOBECODEBANC");
    }
}

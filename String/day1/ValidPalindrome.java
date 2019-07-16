package main.java.ChinaHadoop_AI_Offer.String.day1;

/**
 * 有效回文字符串
 * https://leetcode.com/problems/valid-palindrome/
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s=s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if(s.equals(""))
            return true;
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome=new ValidPalindrome();
        if(validPalindrome.isPalindrome("OP")){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }
}

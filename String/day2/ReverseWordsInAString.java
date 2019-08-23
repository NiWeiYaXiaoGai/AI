package main.java.ChinaHadoop_AI_Offer.String.day2;

/**
 * Reverse Words in a String
 * Given an input string, reverse the string word by word.
 * 时间复杂度：O（n）n为字符串中单词个数
 * 空间复杂度：O(m) n为字符串长度
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder();
        //通过空格将字符串分隔，连续的空格会被分隔成空字符串
        String[] arr=s.split(" ");
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i].length()>0){
                str.append(arr[i]);
                str.append(" ");
            }
        }
        if(str.toString().equals(""))
            return "";
        else
            return str.substring(0,str.length()-1);
    }

    public static void main(String[] args) {
        String str="  the sky is blue";
        String [] arr = str.split(" ");
        for(String ss : arr){
            System.out.println(ss);
        }
        ReverseWordsInAString reverseWordsInAString=new ReverseWordsInAString();
        System.out.println(reverseWordsInAString.reverseWords(str));
    }
}


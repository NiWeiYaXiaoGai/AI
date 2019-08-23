package main.java.ChinaHadoop_AI_Offer.Math.day26;

import java.util.Random;

/**
 * https://blog.csdn.net/xc889078/article/details/9734741
 * 已知有个rand7()的函数，返回1到7随机自然数，
 * 让利用这个rand7()构造rand10() 随机1~10
 */
public class RandMethod {
    public static void main(String[] args) {
        Random random=new Random();
        while(true){
            int a=0;
            int b=0;
            while (a+b<40){  //产生随机数40-49
                a=random.nextInt(7)*7; //产生随机数0-42
                b=random.nextInt(7)%7+1;//产生随机数1-7
            }
            System.out.println(a*b%10+1);
        }



    }
}

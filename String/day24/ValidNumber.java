package main.java.ChinaHadoop_AI_Offer.String.day24;

public class ValidNumber {
    public static boolean isNumber(String s) {
        /**、
         * https://leetcode.com/problems/valid-number/submissions/
         * https://leetcode-cn.com/problems/valid-number/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-4/
         * 状态机算法，归纳总结每一种情况，遍历每一个字符，根据上一个状态判断状态的转换
         * 时间复杂度O（n）
         * 空间复杂度O（1）
         */
        s=s.trim(); //删除首尾的空格
        int state=0;
        char c;
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            switch (c){
                case '+':
                case '-':
                    if(state==0){
                        state=1;
                    }else if(state==4){
                        state=6;
                    }else{
                        return false;
                    }
                    break;
                case '.':
                    if(state==0 || state==1){
                        state=7;
                    }else if(state==2){
                        state=3;
                    }else {
                        return false;
                    }
                    break;
                case 'e':
                    if(state==2 || state==3 || state==8){
                        state=4;
                    }else{
                        return false;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    switch (state){
                        case 0:
                        case 1:
                        case 2:
                            state=2;
                            break;
                        case 7:
                        case 8:
                            state=8;
                            break;
                        case 3:
                            state=3;
                            break;
                        case 4:
                        case 5:
                        case 6:
                            state=5;
                            break;
                        default:
                            return false;
                    }
                    break;
               default:
                   return false;
            }
        }
        switch (state){
            case 2:
            case 3:
            case 5:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        isNumber("0");
    }

}

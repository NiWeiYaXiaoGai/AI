package main.java.ChinaHadoop_AI_Offer.Tree.day15;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReachANumber {
    /**
     * 第一种解法
     * trick1:正负数对称
     * trick2:当1+2+...+n>target的时候，diff=dum-target为偶数的时候，只要d/2往反方向走即可
     * diff为基数，若此时n为基数，则diff+n+1为偶数
     *             若此时n为偶数数，则diff+n+2为偶数
     */

    /**
     * 第二种解法
     * BFS宽度优先搜索
     */
    public static int reachNumber(int target) {
        int max=2*Math.abs(target);
        int depth=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        int pre;
        while(depth<=max){
            int leafCount=queue.size();
            depth++;
            for(int i=0;i<leafCount;i++){
                if(queue.peek()==target){
                    return depth-1;
                }else{
                    pre=queue.poll();
                    queue.add(pre+depth);
                    queue.add((pre-depth));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        reachNumber(-1);
    }

}

package main.java.ChinaHadoop_AI_Offer.Array.day24;

import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {
    /**
     * 回溯+剪枝
     * 时间复杂度O（n!）
     * 空间复杂度O（n）
     */
    private List<Integer> res;
    private int count=0;
    public String getPermutation(int n, int k) {
        List<Integer> sub=new LinkedList<>();
        trackBack(sub,n,k,0);
        StringBuilder str=new StringBuilder();
        for(Integer e:res){
            str.append(e);
        }
        return str.toString();
    }

    private void trackBack(List<Integer> sub,int n,int k,int depth){
        if(depth==n){
            count++;
            if(count == k){
                res=new LinkedList<>(sub);
            }
            return;
        }

        for(int i=1;count<k && i<=n;i++){
            if(sub.contains(i)){
                continue;
            }
            sub.add(i);
            trackBack(sub,n,k,depth+1);
            sub.remove(depth);
        }
    }

    public static void main(String[] args) {
        PermutationSequence test=new PermutationSequence();
        test.getPermutation(4,9);
    }
}

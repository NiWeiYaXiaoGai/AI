package main.java.ChinaHadoop_AI_Offer.Tree.day26;

import main.java.ChinaHadoop_AI_Offer.Tree.day11.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubtreeWithAllTheDeepestNodes {
    /**
     * target：返回一个包含所有最深叶子节点的最小子树
     * 如果一个根节点的左右子树的深度相同，那么这个节点就是返回值
     * 如果右子树的深度比左子树大，遍历右子树，否则遍历左子树
     * 时间复杂度O（log(n)）
     * 空间复杂度O（1）
     */
    public TreeNode subtreeWithAllDeepest(TreeNode node) {
        if(node==null)
            return null;
        int leftDepth=maxDepth(node.left);
        int rightDepth=maxDepth(node.right);
        if(leftDepth==rightDepth){
            return node;
        }else if(leftDepth>rightDepth){
            return subtreeWithAllDeepest(node.left);
        }else{
            return subtreeWithAllDeepest(node.right);
        }
    }
    private int maxDepth(TreeNode node){
        if(node==null)
            return 0;
        return Math.max(maxDepth(node.left),maxDepth(node.right))+1;
    }

    public static void main(String[] args) {
        Map<String,Object> map= new HashMap<>();
        map.put("a",null);
        String s=(String)map.get("a");
        System.out.println(map.containsKey("a"));
    }
}

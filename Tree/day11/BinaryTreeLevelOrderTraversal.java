package main.java.ChinaHadoop_AI_Offer.Tree.day11;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    /**
     * https://leetcode.com/problems/binary-tree-level-order-traversal/
     * 递归遍历,使用数组存储上一层的节点
     * 时间复杂度O（n）,每个节点遍历一次
     * 空间复杂度O（n）
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        List<TreeNode> pre=new ArrayList<>();
        if(root!=null){
            pre.add(root);
            List<Integer>  subResult=new ArrayList<>();
            subResult.add(root.val);
            res.add(subResult);
            levelOrderImpl(pre,res);
        }
        return res;
    }

    private void levelOrderImpl(List<TreeNode> pre,List<List<Integer>> res){
        if(pre.size()==0)
            return;
        List<TreeNode> cur=new ArrayList<>();
        List<Integer>  subResult=new ArrayList<>();
        for(TreeNode node:pre){
            if(node.left!=null){
                cur.add(node.left);
                subResult.add(node.left.val);
            }
            if(node.right!=null){
                cur.add(node.right);
                subResult.add(node.right.val);
            }
        }
        if(subResult.size()!=0){
            res.add(subResult);
        }
        levelOrderImpl(cur,res);
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        if(null==null){
            list.add(1);
            list.add(null);
            list.add(2);
        }

    }
}

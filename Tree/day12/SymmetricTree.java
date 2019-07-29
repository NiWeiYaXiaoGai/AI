package main.java.ChinaHadoop_AI_Offer.Tree.day12;

import main.java.ChinaHadoop_AI_Offer.Tree.day11.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
    /**
     * https://leetcode.com/problems/symmetric-tree/submissions/
     *双指针递归，从根节点左右方向出发，比较值是否相等
     * 时间复杂度O（n）
     * 空间复杂度O（1）
     */
    public boolean isSymmetric(TreeNode root) {
        TreeNode root2=root;
        return isSymmetricImpl(root,root2);
    }

    private boolean isSymmetricImpl(TreeNode node1,TreeNode node2){
        if(node1==null && node2==null)
            return true;
        if(node1==null || node2==null)
            return false;
        if(node1.val!=node2.val)
            return false;
        return isSymmetricImpl(node1.left,node2.right)&&isSymmetricImpl(node1.right,node2.left);
    }


}

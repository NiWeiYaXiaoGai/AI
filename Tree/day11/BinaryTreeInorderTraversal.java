package main.java.ChinaHadoop_AI_Offer.Tree.day11;

import java.util.ArrayList;
import java.util.List;
/**
 *https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {
    /**
     * 递归遍历
     * 时间复杂度O（n）,每个节点遍历一次
     * 空间复杂度O（n）,树的深度最多为n
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorderTraversal(root,list);
        return list;
    }

    private void inorderTraversal(TreeNode node,List<Integer> list){
        if(node==null)
            return;
        inorderTraversal(node.left,list);
        list.add(node.val);
        inorderTraversal(node.right,list);
    }
}

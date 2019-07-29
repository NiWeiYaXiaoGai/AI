package main.java.ChinaHadoop_AI_Offer.Tree.day11;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    /**
     * https://leetcode.com/problems/binary-tree-postorder-traversal/
     * 递归遍历
     * 时间复杂度O（n）,每个节点遍历一次
     * 空间复杂度O（n）,树的深度最多为n
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        postorderTraversal(root,list);
        return list;
    }

    private void postorderTraversal(TreeNode node, List<Integer> list){
        if(node==null)
            return;
        postorderTraversal(node.left,list);
        postorderTraversal(node.right,list);
        list.add(node.val);
    }
}

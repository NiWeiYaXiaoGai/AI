package main.java.ChinaHadoop_AI_Offer.Tree.day13;

import main.java.ChinaHadoop_AI_Offer.Tree.day11.TreeNode;

public class SubtreeOfAnotherTree {
    /**
     * https://leetcode.com/problems/subtree-of-another-tree/
     * 前序遍历每一个节点每一个节点，然后该节点及其子树是否与t相等
     * 时间复杂度O（nlog(n)）
     * 空间复杂度O（1）
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null && t==null)
            return true;
        if(s!=null && t==null)
            return true;
        if(s==null || t==null)
            return false;
        return isSameTree(s,t) || isSubtree(s.left,t) ||isSubtree(s.right,t);

    }

    private boolean isSameTree(TreeNode s, TreeNode t){
        if(s==null && t==null){
            return true;
        }
        if(s==null || t==null || s.val!=t.val){
            return false;
        }
        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
    }

    public static void main(String[] args) {
        TreeNode s=new TreeNode(3);
        s.right=new TreeNode(5);
        TreeNode t=new TreeNode(4);
        t.left=new TreeNode(1);
        t.right=new TreeNode(2);
        s.left=t;
        SubtreeOfAnotherTree test =new SubtreeOfAnotherTree();
        test.isSubtree(s,t);
    }
}

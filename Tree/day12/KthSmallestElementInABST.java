package main.java.ChinaHadoop_AI_Offer.Tree.day12;

import main.java.ChinaHadoop_AI_Offer.Tree.day11.TreeNode;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementInABST {

    private int count;
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        return traverseDFS(root);
    }
    private int traverseDFS(TreeNode node){
        if(node==null)
            return -1;
        int val=traverseDFS(node.left);
        if(count==0){
            return val;
        }
        if(--count==0){
            return node.val;
        }
        return traverseDFS(node.right);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(1);
        root.right=new TreeNode(4);
        root.left.right=new TreeNode(2);
        KthSmallestElementInABST test=new KthSmallestElementInABST();
        test.kthSmallest(root,1);
    }
}

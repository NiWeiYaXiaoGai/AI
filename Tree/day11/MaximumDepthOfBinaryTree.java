package main.java.ChinaHadoop_AI_Offer.Tree.day11;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {
    /**
     * 递归遍历左右子树
     * 时间复杂度O（n）
     * 空间复杂度O（n）
     */
    private int max=0;
    public int maxDepth(TreeNode root) {
        maxDepthImpl(root,0);
        return max;
    }
    private void maxDepthImpl(TreeNode node,int depth){
        if(node==null)
            return;
        depth++;
        if(depth>max)
            max=depth;
        maxDepthImpl(node.left,depth);
        maxDepthImpl(node.right,depth);
    }
}

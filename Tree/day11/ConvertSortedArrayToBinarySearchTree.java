package main.java.ChinaHadoop_AI_Offer.Tree.day11;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/submissions/
 * 二叉查找树（Binary Search Tree），也称有序二叉树（ordered binary tree）,排序二叉树（sorted binary tree），是指一棵空树或者具有下列性质的二叉树：
 * 若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 任意节点的左、右子树也分别为二叉查找树。
 *
 * 再复习下什么是平衡二叉树（引自GeekforGeek）：
 * An empty tree is height-balanced. A non-empty binary tree T is balanced if:
 *    1) Left subtree of T is balanced
 *    2) Right subtree of T is balanced
 *    3) The difference between heights of left subtree and right subtree is not more than 1.
 */
public class ConvertSortedArrayToBinarySearchTree {
    /**
     * 选数组的中点构造根节点，然后递归构造左子树和右子树
     * 时间复杂度O（n）
     * 空间复杂度O（n）
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return reverseRootNode(nums,0,nums.length-1);
    }

    private TreeNode reverseRootNode(int[] nums,int left,int right){
        if(left>right)
            return null;
        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=reverseRootNode(nums,left,mid-1);
        root.right=reverseRootNode(nums,mid+1,right);
        return root;
    }
}

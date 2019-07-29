package main.java.ChinaHadoop_AI_Offer.Tree.day11;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListToBinarySearchTree {
    /**
     * 选链表的中点构造根节点，然后递归构造左子树和右子树，快慢指针获取链表中部节点
     * 时间复杂度O（n）
     * 空间复杂度O（n）
     */
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        return reverseRootNode(head,null);
    }
    private TreeNode reverseRootNode(ListNode head,ListNode tail){
        if(head==tail)
            return null;
        ListNode mid=findMiddleNode(head,tail);
        TreeNode root=new TreeNode(mid.val);
        root.left=reverseRootNode(head,mid);
        root.right=reverseRootNode(mid.next, tail);
        return root;
    }
    private ListNode findMiddleNode(ListNode head,ListNode tail){
        ListNode fast=head;
        ListNode slow=head;
        //把tail当做null看待
        while(fast!=null && fast.next!=null && fast!=tail && fast.next!=tail){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}

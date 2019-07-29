package main.java.ChinaHadoop_AI_Offer.LinkedList.day9;

public class RemoveLinkedListElements {
    /**
     * https://leetcode.com/problems/remove-linked-list-elements/
     * 虚拟头节点，遍历链表
     * 时间复杂度O(m+n)
     * 空间复杂度O(m)
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy;
        while(cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}

package main.java.ChinaHadoop_AI_Offer.LinkedList.day9;

/**
 *https://leetcode.com/problems/sort-list/
 */
public class SortList {
    /**
     * 链表归并排序
     * 时间复杂度O(nlog(n))
     * 空间复杂度O(1)
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode mid=findMiddle(head);
        ListNode rightHead=mid.next;
        mid.next=null;
        ListNode leftHead=sortList(head);
        rightHead=sortList(rightHead);
        return merge(leftHead, rightHead);
    }

    private ListNode findMiddle(ListNode head){
        ListNode fast=head.next;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode leftNode,ListNode rightNode){
        ListNode dummyHead=new ListNode(0);
        ListNode curNode=dummyHead;
        while(leftNode!=null && rightNode!=null){
            if(leftNode.val<=rightNode.val){
                curNode.next=leftNode;
                leftNode=leftNode.next;
            }else{
                curNode.next=rightNode;
                rightNode=rightNode.next;
            }
            curNode=curNode.next;
        }
        while(leftNode!=null){
            curNode.next=leftNode;
            leftNode=leftNode.next;
            curNode=curNode.next;
        }
        while(rightNode!=null){
            curNode.next=rightNode;
            rightNode=rightNode.next;
            curNode=curNode.next;
        }
        return dummyHead.next;
    }
}

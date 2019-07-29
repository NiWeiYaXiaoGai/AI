package main.java.ChinaHadoop_AI_Offer.LinkedList.day8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 双指针算法
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class RemoveNthNodeFromEndOfList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null)
            return null;
        ListNode fast=head;
        ListNode cur=head;
        ListNode dummyHead=new ListNode(0);
        ListNode pre=dummyHead;
        pre.next=head;
        for(int i=1;i<n;i++){
            fast=fast.next;
        }
        while(fast.next!=null){
            fast=fast.next;
            cur=cur.next;
            pre=pre.next;
        }
        if(cur==fast){
            //表示删除的是最后一个元素
            pre.next=null;
        }else{
            pre.next=fast;
        }
        if(cur==head){
            //表示删除的节点是头节点
            return pre.next.next;
        }else{
            return head;
        }

    }

    public static void main(String[] args) {
        Set<Integer> set=new HashSet<>();
        Map<Integer,Integer> map=new HashMap<>();
    }
}

package main.java.ChinaHadoop_AI_Offer.LinkedList.day9;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    /**
     *Intersection of Two Linked Lists
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set=new HashSet<>();
        while(headA!=null){
            set.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(set.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return null;
    }
}

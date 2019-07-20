package main.java.ChinaHadoop_AI_Offer.LinkedList.day1;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * 快慢指针法，相遇点到环入口的距离与起点到环入口的距离相等
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class LinkedListCycleII {
   class ListNode {
       int val;
       ListNode next;

       ListNode(int x) {
           val = x;
           next = null;
       }
   }
    public ListNode detectCycle(ListNode head) {
       ListNode slow=head;
       ListNode fast=head;
       while(fast!=null && fast.next!=null){
           fast=fast.next.next;
           slow=slow.next;
           if(fast==slow){
               //此时slow为相遇点，相遇点到环入口的距离与起点到环入口的距离相等
               while(head!=slow){
                   head=head.next;
                   slow=slow.next;
               }
               return head;
           }
       }
       return null;
    }
}

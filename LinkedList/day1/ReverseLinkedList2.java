package main.java.ChinaHadoop_AI_Offer.LinkedList.day1;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class ReverseLinkedList2 {
   public class ListNode {
       int val;
       ListNode next;

       ListNode(int x) {
           val = x;
       }
   }

    public ListNode reverseBetween(ListNode head, int m, int n) {
       ListNode dummyhead=new ListNode(0);
       dummyhead.next=head;
       ListNode pre=dummyhead;
       ListNode tail=null;
       ListNode reverseHead=head;
       ListNode reverseTail=null;
       ListNode cur=dummyhead;
       for(int i=0;i<m;i++){
           if(i==m-1){
               pre=cur;
           }
           cur=cur.next;
       }
       //此时的cur为逆转前的头结点，也是逆转后的尾部节点
       ListNode newhead=new ListNode(0);
       ListNode revereTail=cur;
       ListNode next;
       for(int i=m;i<=n;i++){
           next=cur.next;
           cur.next=newhead;
           newhead=cur;
           cur=next;
       }
       pre.next=newhead;
       revereTail.next=cur;
       if(m==1){
           return newhead;
       }else{
           return head;
       }
    }

    public static void main(String[] args) {

    }
}

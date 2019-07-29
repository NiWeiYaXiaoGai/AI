package main.java.ChinaHadoop_AI_Offer.LinkedList.day9;

public class MergeKSortedLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 分而治之算法，这样k个链表只用合并log(k)次
     * 时间复杂度O(nklog(k))
     * 空间复杂度O(1)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        return divideAndConquer(lists,0,lists.length-1);
    }

    private ListNode divideAndConquer(ListNode[] listNodes,int start,int end){
        if(start==end){
            return listNodes[start];
        }
        int mid=start+(end-start)/2;
        ListNode left=divideAndConquer(listNodes,start,mid);
        ListNode right=divideAndConquer(listNodes,mid+1,end);
        //二分至只剩下一个元素，假设[0,1,2],左子树二分至0和1  右子树二分至2和2
        return mergrTwoList(left,right);
    }
    private ListNode mergrTwoList(ListNode left,ListNode right){
        ListNode dummy=new ListNode(-1);
        ListNode head=dummy;
        ListNode temp;
        while(left!=null && right!=null){
            if(left.val<=right.val){
                head.next=left;
                left=left.next;
            }else {
                head.next=right;
                right=right.next;
            }
            head=head.next;
        }
        while(left!=null){
            head.next=left;
            left=left.next;
            head=head.next;
        }
        while(right!=null){
            head.next=right;
            right=right.next;
            head=head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists test=new MergeKSortedLists();
        ListNode[] lists=new ListNode[0];
        test.mergeKLists(lists);
    }
}

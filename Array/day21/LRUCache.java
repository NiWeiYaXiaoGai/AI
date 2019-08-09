package main.java.ChinaHadoop_AI_Offer.Array.day21;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {
    /**
     * hashMap+双链表
     * 时间复杂度O(1)
     * 空间复杂度O(n)
     * ps:如果map里只有一个节点，设置该节点是头节点的同时也要设置该节点是尾结点
     */
    private class Node{
        int key;
        int val;
        Node pre;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private Map<Integer,Node> map;
    private int size;
    private int capacity;
    private Node head;
    private Node tail;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        this.capacity=capacity;
        size=0;
    }

    public int get(int key) {
        Node node=map.get(key);
        if(null!=node){
            remove(node);
            setHead(node);
            return node.val;
        }else{
            return -1;
        }
    }

    private void remove(Node node){
        Node pre=node.pre;
        Node next=node.next;
        if(pre==null){
            head=node.next;
            if(head!=null){
                head.pre=null;
            }
        }
        if(next==null){
            tail=node.pre;
            if(tail!=null){
                tail.next=null;
            }
        }
        if(pre!=null && next!=null){
            pre.next=next;
            next.pre=pre;
        }
    }

    private void setHead(Node node){
        node.pre=null;
        node.next=head;
        if(head!=null){
            head.pre=node;
        }
        head=node;
        //ps:如果map里只有一个节点，设置该节点是头节点的同时也要设置该节点是尾结点
        if(size==1){
            tail=head;
        }
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){  //若该节点存在，则更新该节点并将该节点设置为头结点
            Node node=map.get(key);
            node.val=value;
            remove(node);
            setHead(node);
            if(node==tail && node.pre!=null){
                tail=node.pre;
            }
        }else{
            //若该节点不存在，则添加该节点并将该节点设置为头结点
            Node node=new Node(key,value);
            map.put(key,node);
            size++;
            if(size==1){
                head=node;
                tail=node;
            }else{
                setHead(node);
            }
            if(size>capacity){
                map.remove(tail.key);
                size--;
                remove(tail);//链表中移除节点只是将尾指针节点向前移动
            }
        }
    }

    public static void main(String[] args) {
//        LRUCache cache=new LRUCache(2);
//        cache.put(1,1);
//        cache.put(2,2);
//        cache.get(1);
//        cache.put(3,3);
//        cache.get(2);
//        cache.put(4,4);
//        cache.get(1);
//        cache.get(3);
//        cache.get(4);
        LRUCache cache=new LRUCache(1);
        cache.put(2,1);
        cache.get(2);
        cache.put(3,2);
        cache.get(2);
        cache.get(3);

    }
}

package main.java.ChinaHadoop_AI_Offer.Tree.day20;

import java.util.Map;
import java.util.TreeMap;

/**
 * 字典树
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class ImplementTrie {
    //成员内部类
    private class Node{
        public boolean isWord;
        public Map<Character,Node> next;
        public Node(boolean isWord){
            this.isWord=isWord;
            next=new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }
    private Node root;
    private int size;
    /** Initialize your data structure here. */
    public ImplementTrie() {
        root=new Node();
        size=0;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur=root;
        for(int i=0;i<word.length();i++){
            Character c=word.charAt(i);
            if(!cur.next.containsKey(c))
                cur.next.put(c,new Node());
            cur=cur.next.get(c);//cur表示单词i位置上的node
        }
        //判断该节点处是否是一个单词，
        if(!cur.isWord){
            cur.isWord=true;
            size++;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur=root;
        for(int i=0;i<word.length();i++){
            Character c=word.charAt(i);
            if(!cur.next.containsKey(c))
                return false;
            cur=cur.next.get(c);
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur=root;
        for(int i=0;i<prefix.length();i++){
            Character c=prefix.charAt(i);
            if(!cur.next.containsKey(c))
                return false;
            cur=cur.next.get(c);
        }
        return true;
    }
}

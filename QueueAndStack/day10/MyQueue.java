package main.java.ChinaHadoop_AI_Offer.QueueAndStack.day10;

import java.util.Stack;

public class MyQueue {
    /**
     *java中的stack底层实现是vector,而vector的底层实现是数组
     * 时间复杂度 push操作O(1) peek操作O(n) pop操作O(n) empty操作O(1)
     * 空间复杂度O(n)
     */
    /** Initialize your data structure here. */
    Stack<Integer> pushStack;
    Stack<Integer> popStack;
    int size;
    public MyQueue() {
        pushStack=new Stack<>();
        popStack=new Stack<>();
        size=0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
        size++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        size--;
        return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(size==0){
            return true;
        }else{
            return false;
        }
    }
}

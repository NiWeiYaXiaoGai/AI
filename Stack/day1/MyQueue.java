package main.java.ChinaHadoop_AI_Offer.Stack.day1;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.util.Stack;

public class MyQueue {
    /**
     *
     */
    /** Initialize your data structure here. */
    Stack<Integer> pushStack;
    Stack<Integer> popStack;
    public MyQueue() {
        pushStack=new Stack<>();
        popStack=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
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
        if(pushStack.isEmpty() && popStack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}

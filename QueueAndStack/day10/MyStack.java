package main.java.ChinaHadoop_AI_Offer.QueueAndStack.day10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
public class MyStack {
    /**
     * 双队列，一个队列入队，一个队列出队
     * 时间复杂度 push操作O(1) peek操作O(n) pop操作O(n) empty操作O(1)
     *空间复杂度O(n)
     */
    Queue<Integer> queue1;//插入元素
    Queue<Integer> queue2;//移除元素
    int size;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
        size=0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        while(!queue2.isEmpty()){  //出队队列不为空，元素全部回收至入队队列
            queue1.offer(queue2.poll());
        }
        queue1.offer(x);
        size++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue2.isEmpty()){
            while (queue1.size()>1){
                queue2.offer(queue1.poll());
            }
            Queue<Integer> temp=queue1;
            queue1=queue2;
            queue2=temp;
        }
        size--;
        return queue2.poll();
    }

    /** Get the top element. */
    public int top() {
        if(queue2.isEmpty()){
            while (queue1.size()>1){
                queue2.offer(queue1.poll());
            }
            Queue<Integer> temp=queue1;
            queue1=queue2;
            queue2=temp;
        }
        return queue2.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(size==0){
            return true;
        }else{
            return false;
        }
    }
}

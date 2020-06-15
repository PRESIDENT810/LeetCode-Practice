import java.util.*;

public class main {
}

class MyQueue {
    public Stack<Integer> stack;
    int front;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (this.stack.empty()) this.front = x;
        this.stack.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> temp_stack = new Stack<>();
        while (!this.stack.empty()){
            temp_stack.push(this.stack.pop());
        }
        int res = temp_stack.pop();
        if (!temp_stack.empty()) this.front = temp_stack.peek();
        while (!temp_stack.empty()){
            this.stack.push(temp_stack.pop());
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        return this.front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.stack.empty();
    }
}
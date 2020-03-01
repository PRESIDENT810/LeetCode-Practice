import java.util.*;

public class main {
    public static void main(String args[]{

    }
}

class MyStack {
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> temp_q = new LinkedList<>();
        while (!this.queue.isEmpty()){
            temp_q.add(this.queue.remove());
        }
        this.queue.add(x);
        while (!temp_q.isEmpty()){
            this.queue.add(temp_q.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return this.queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return this.queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
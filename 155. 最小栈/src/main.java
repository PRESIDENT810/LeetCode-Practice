import java.util.LinkedList;
import java.util.PriorityQueue;

public class main {
}

class MinStack {
    private LinkedList<Integer> stack;
    private PriorityQueue<Integer> heap;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new LinkedList<>();
        this.heap = new PriorityQueue<>();
    }

    public void push(int x) {
        this.stack.add(x);
        this.heap.add(x);
    }

    public void pop() {
        if (this.stack.isEmpty()) return;
        int x = this.stack.pollLast();
        this.heap.remove(x);
    }

    public int top() {
        return this.stack.peekLast();
    }

    public int getMin() {
        if (this.heap.isEmpty()) return Integer.parseInt(null);
        return this.heap.peek();
    }
}
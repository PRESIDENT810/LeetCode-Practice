import java.util.LinkedList;

public class main {
}

class MinStack {
    private LinkedList<Integer> min_list;
    private LinkedList<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new LinkedList<>();
        this.min_list = new LinkedList<>();
    }

    public void push(int x) {
        this.stack.add(x);
        if (this.min_list.isEmpty()) this.min_list.add(x);
        else if (x < this.min_list.peekLast()) this.min_list.add(x);
        else this.min_list.add(this.min_list.peekLast());
    }

    public void pop() {
        if (this.stack.isEmpty()) return;
        this.stack.pollLast();
        this.min_list.pollLast();
    }

    public int top() {
        return this.stack.peekLast();
    }

    public int getMin() {
        return this.min_list.peekLast();
    }
}
import java.util.*;

public class main {
}

class MaxQueue {

    LinkedList<Integer> Queue;
    LinkedList<Integer> subQueue;

    public MaxQueue() {
        this.Queue = new LinkedList<>();
        this.subQueue = new LinkedList<>();
    }

    public int max_value() {
        if (this.subQueue.peek() == null) return -1;
        return this.subQueue.peek();
    }

    public void push_back(int value) {
        this.Queue.add(value);
        while (!this.subQueue.isEmpty() && this.subQueue.getLast() < value) {
            this.subQueue.removeLast();
        }
        this.subQueue.add(value);
    }

    public int pop_front() {
        if (this.Queue.isEmpty()) return -1;
        int pop = this.Queue.remove();
        if (pop == this.subQueue.peek()) this.subQueue.remove();
        return pop;
    }
}
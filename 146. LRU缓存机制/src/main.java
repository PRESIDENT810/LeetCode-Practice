import java.util.*;

class main {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(2,1);
        lru.put(1,1);
        lru.put(2,3);
        lru.put(4,1);
        lru.get(1);
        lru.get(2);
    }
}

class LRUCache {
    int capacity;
    List<Integer> stack = new LinkedList<>();
    Map<Integer, Integer> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        int index = 0;
        for (int i : this.stack) {
            if (i == key) {
                this.stack.remove(index);
                this.stack.add(i);
                return this.map.get(i);
            }
            index++;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)) { // key in cache
            this.map.put(key, value);
            this.stack.remove((Integer) key);
            this.stack.add(key);
        } else { // key not in cache
            if (this.stack.size() == this.capacity) {
                int removed_key = this.stack.remove(0);
                this.map.remove(removed_key);
            }
            this.stack.add(key);
            this.map.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
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

class Node{
    Node prev, next;
    int key;
    int value;
    Node(){}
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    Node Head, Tail;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.Head = new Node();
        this.Tail = new Node();
        this.Head.next = this.Tail;
        this.Tail.prev = this.Head;
    }

    public int get(int key) {
        // if key already in cache
        if (this.map.get(key) != null){
            int value =  this.map.get(key).value;
            remove(key);
            add(key, value);
            return value;
        }
        else return -1;
    }

    public void put(int key, int value) {
        // if key already in cache
        if (this.map.containsKey(key)){
            remove(key);
            add(key, value);
        }
        // if key not in cache
        else{
            if (this.size == this.capacity){ // cache full
                remove(this.Head.next.key);
            }
            add(key, value);
        }
    }

    public void remove(int key){
        this.size--;
        Node removed_node = this.map.get(key);
        removed_node.prev.next = removed_node.next;
        removed_node.next.prev = removed_node.prev;
        this.map.remove(key);
    }

    public void add(int key, int value){
        this.size++;
        Node added_node = new Node(key, value);
        this.Tail.prev.next = added_node;
        added_node.prev = this.Tail.prev;
        added_node.next = this.Tail;
        this.Tail.prev = added_node;
        this.map.put(key, added_node);
    }
}
import java.util.*;

class main {
    public static void main(String args[]) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(2);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(2);
        ListNode[] listNodes = {l1, l2};
        new Solution23().mergeKLists(listNodes);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        // initialize a new dummy node
        ListNode dummy = new ListNode(-1);
        ListNode crt = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (ListNode list: lists){
            if (list != null) pq.offer(list);
        }
        while (!pq.isEmpty()){
            ListNode temp = pq.poll();
            if (temp.next != null) pq.offer(temp.next);
            crt.next = temp;
            crt = temp;
        }
        crt.next = null;
        return dummy.next;
    }
}
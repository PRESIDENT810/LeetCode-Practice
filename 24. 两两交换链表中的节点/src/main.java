public class main {
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        return recursion(head);
    }

    public ListNode recursion(ListNode head){
        // base case
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode new_head = head.next;
        head.next = recursion(new_head.next);
        new_head.next = head;
        return new_head;
    }
}
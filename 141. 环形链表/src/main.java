public class main {
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode fast_ptr = head.next;
        ListNode slow_ptr = head;
        ListNode temp;

        while (fast_ptr != null && slow_ptr != null) {
            if (fast_ptr == slow_ptr) return true;

            if (fast_ptr == null) continue;

            if (fast_ptr.next != null) fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;

            if (slow_ptr.next == null) return false;
        }
        return false;
    }
}
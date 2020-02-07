public class main {
    public static void main(String args[]){
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        ListNode ans = new Solution142().detectCycle(head);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        // get ring length
        ListNode fast_ptr = head;
        ListNode slow_ptr = head;
        int fast_cnt = 0;
        int slow_cnt = 0;

        while (true) {
            if (fast_ptr.next == null || fast_ptr.next.next == null) return null;
            fast_ptr = fast_ptr.next.next;
            fast_cnt += 2;
            slow_ptr = slow_ptr.next;
            slow_cnt += 1;
            if (slow_ptr == fast_ptr) {
                break;
            }
            if (fast_ptr.next == slow_ptr) {
                fast_cnt += 1;
                break;
            }
        }

        int ring_len = fast_cnt - slow_cnt;

        // get the ring start
        fast_ptr = head;
        slow_ptr = head;

        while (ring_len != 1) {
            fast_ptr = fast_ptr.next;
            ring_len--;
        }
        while (fast_ptr.next != slow_ptr) {
            fast_ptr = fast_ptr.next;
            slow_ptr = slow_ptr.next;
        }
        return slow_ptr;
    }
}

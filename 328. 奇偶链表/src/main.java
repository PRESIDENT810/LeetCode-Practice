public class main {
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

class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode even_head = head;
        ListNode odd_head = head.next;
        ListNode even_end = even_head;
        ListNode odd_end = odd_head;
        int crt_idx = 2;
        ListNode crt = odd_head.next;
        while (crt != null) {
            if (crt_idx % 2 == 0) {
                even_end.next = crt;
                even_end = even_end.next;
            } else {
                odd_end.next = crt;
                odd_end = odd_end.next;
            }
            crt = crt.next;
            crt_idx++;
        }
        even_end.next = odd_head;
        odd_end.next = null;
        return head;
    }
}
import java.util.*;

class main {
    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        new Solution86().partition(head, 3);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(-1);
        ListNode bigger = new ListNode(-1);
        ListNode smaller_end = smaller;
        ListNode bigger_end = bigger;
        ListNode crt = head;
        while (crt != null){
            if (crt.val < x) { // smaller than x
                smaller_end.next = crt;
                smaller_end = crt;
            }
            else {
                bigger_end.next = crt;
                bigger_end = crt;
            }
            crt = crt.next;
        }
        smaller_end.next = bigger.next;
        bigger_end.next = null;
        return smaller.next;
    }
}
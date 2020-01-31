public class main {

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head.next == null) return head;

        ListNode tail = reverseList(head.next);
        head.next.next = head; // fuck this step, bitch ass tricky
        head.next = null;

        return tail;
    }
}
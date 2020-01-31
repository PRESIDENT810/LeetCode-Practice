public class main {
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode current = head;
        ListNode null_head = new ListNode(0);
        null_head.next = head;
        ListNode last = null_head;

        while (current != null) {
            if (current.val == val) {
                last.next = current.next;
            }
            else last = current;
            current = current.next;
        }
        return null_head.next;
    }
}
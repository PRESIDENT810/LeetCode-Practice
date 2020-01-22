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

        ListNode current = head;
        ListNode temp;

        while (current.next != null) {
            if (current.next == head) return true;

            temp = current.next;
            current.next = head;
            current = temp;
        }
        return false;
    }
}
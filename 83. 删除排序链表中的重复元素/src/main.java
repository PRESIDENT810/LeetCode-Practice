public class main {
    public static void main(String args[]) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode current = head;
        ListNode last = head;

        int dup = head.val-1;

        while (current.next != null) {
            if (dup == current.val) {
                last.next = current.next;
            } else {
                dup = current.val;
                last = current;
            }
            current = current.next;
        }

        if (dup == current.val) last.next = null;

        return head;
    }
}

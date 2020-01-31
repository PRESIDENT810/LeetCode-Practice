public class main {

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        ListNode current = head;
        ListNode temp;
        ListNode reverse_head = null;

        while (current != null) {
            temp = current;
            current = current.next;
            temp.next = reverse_head;
            reverse_head = temp;
        }
        return reverse_head;
    }
}
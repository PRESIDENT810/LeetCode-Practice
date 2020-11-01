class main {
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

class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        // find the length
        ListNode ptr1 = head;
        int len = 0;
        while (ptr1 != null) {
            ptr1 = ptr1.next;
            len++;
        }
        k = k % len;
        if (k == 0) return head;
        // let ptr1 go k steps
        ptr1 = head;
        ListNode ptr2 = head;
        while (k != 0) {
            if (ptr1 == null) ptr1 = head;
            ptr1 = ptr1.next;
            k--;
            len++;
        }
        // move ptr1 and ptr2 at the same time
        while (ptr1.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        // now ptr2.next is the new head, ptr1 is the old tail
        ListNode new_head = ptr2.next;
        ptr2.next = null;
        ptr1.next = head;
        return new_head;
    }
}

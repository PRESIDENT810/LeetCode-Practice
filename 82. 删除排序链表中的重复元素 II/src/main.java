class main {
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode ptr1 = dummy;
        ListNode ptr2 = dummy.next.next;
        while (ptr2 != null) {
            if (ptr1.next.val == ptr2.val) { // duplicate
                while (ptr2 != null && ptr1.next.val == ptr2.val) {
                    ptr1.next = ptr2;
                    ptr2 = ptr2.next;
                }
                ptr1.next = ptr2;
                if (ptr2 != null) ptr2 = ptr2.next;
            } else { // no duplicate
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }
        return dummy.next;
    }
}
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

class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        // find mid
        while (ptr1 != null && ptr1.next != null) {
            ptr1 = ptr1.next.next;
            ptr2 = ptr2.next;
        }

        // reverse last half
        ListNode reversed_head = reverseList(ptr2);
        ptr2.next = null;

        // merge two list
        ListNode dummy = new ListNode(-1);
        ListNode crt = dummy;
        while (head != null && reversed_head != null) {
            System.out.print(head.val); // debug
            System.out.print(reversed_head.val); // debug
            System.out.print('\n');
            crt.next = head;
            head = head.next;
            crt.next.next = reversed_head;
            crt = reversed_head;
            reversed_head = reversed_head.next;
        }
        crt.next = null;
        return;
    }

    public ListNode reverseList(ListNode head) {
        if (head.next == null) return head;
        ListNode temp = head.next;
        ListNode tail = reverseList(temp);
        temp.next = head;
        return tail;
    }
}
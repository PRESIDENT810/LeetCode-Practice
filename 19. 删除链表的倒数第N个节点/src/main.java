public class main {
    public static void main(String args[]){
        ListNode head = new ListNode(1);
        System.out.print(new Solution19().removeNthFromEnd(head, 1));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr1 = new ListNode(0);
        ptr1.next = head;
        head = ptr1;
        ListNode ptr2 = head;

        while (n != 0) {
            ptr2 = ptr2.next;
            n--;
        }

        while (ptr2 != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ptr1.next = ptr1.next.next;
        return head.next;
    }
}
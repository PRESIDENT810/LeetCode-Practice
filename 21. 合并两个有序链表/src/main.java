public class main {
    public static void main(String args[]){

    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode crt = head;

        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                crt.next = new ListNode(l2.val);
                crt = crt.next;
                l2 = l2.next;
            }
            else {
                crt.next = new ListNode(l1.val);
                crt = crt.next;
                l1 = l1.next;
            }
        }

        if (l1 == null) crt.next = l2;
        else crt.next = l1;

        return head.next;
    }
}
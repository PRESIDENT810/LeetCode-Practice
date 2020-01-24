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

class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB) return headA;
        if (headA == null || headB == null) return null;

        int lenA = 1;
        int lenB = 1;

        ListNode crt_A = headA;
        ListNode crt_B = headB;

        while (crt_A.next != null) {
            crt_A = crt_A.next;
            lenA++;
        }
        while (crt_B.next != null) {
            crt_B = crt_B.next;
            lenB++;
        }

        crt_A = headA;
        crt_B = headB;

        if (lenA > lenB) {
            while (lenA != lenB) {
                crt_A = crt_A.next;
                lenA--;
            }
        }

        else {
            while (lenA != lenB) {
                crt_B = crt_B.next;
                lenB--;
            }
        }

        while (crt_A.next != null) {
            if (crt_A == crt_B) return crt_A;
            crt_A = crt_A.next;
            crt_B = crt_B.next;
        }
        if (crt_A == crt_B) return crt_A;

        return null;
    }
}
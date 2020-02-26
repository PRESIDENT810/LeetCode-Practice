public class main {
    public static void main(String args[]){
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        new Solution234().isPalindrome(head);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return (head.val == head.next.val);

        // get length
        ListNode crt = head;
        int len = 0;
        while (crt.next != null) {
            crt = crt.next;
            len++;
        }
        len = len/2;
        ListNode tail = crt;

        // go to mid
        crt = head;
        while (len != 0) {crt = crt.next; len--;}

        // reverse direction
        ListNode pre = crt;
        ListNode temp;
        crt = crt.next;
        while (crt.next != null){
            temp = crt;
            crt = crt.next;
            temp.next = pre;
            pre = temp;
        }
        crt.next = pre;

        // check palindrome
        while (head != tail && head.next != tail) {
            if (head.val != tail.val) return false;
            head = head.next;
            tail = tail.next;
        }
        if (head.val != tail.val) return false;
        return true;
    }
}
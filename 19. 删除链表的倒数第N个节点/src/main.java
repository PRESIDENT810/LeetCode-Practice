import java.util.*;

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
        int cnt = 0;
        ListNode new_head = new ListNode(-999);
        new_head.next = head;
        ListNode crt = new_head;
        Map<Integer, ListNode> map = new HashMap<>();

        while (crt != null) {
            map.put(cnt, crt);
            cnt++;
            crt = crt.next;
        }

        ListNode cut = map.get(cnt-1-n);
        cut.next = cut.next.next;
        return new_head.next;
    }
}
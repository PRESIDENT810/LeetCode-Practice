import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution2 {
    static public int get_length(ListNode l) {
        int len = 0;
        while (l != null) {
            len++;
            l = l.next;
        }
        return len;
    }

    static public ListNode fillzero(ListNode l, int length){
        ListNode new_l = new ListNode(0);
        ListNode new_init = new_l;

        ListNode l_head = l;

        while (l.next != null) l = l.next;

        for (int i=0; i<length-1; i++){
            new_l.next = new ListNode(0);
            new_l = new_l.next;
        }
        l.next = new_init;
        return l_head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // fill zero to align
        int len1 = get_length(l1);
        int len2 = get_length(l2);

        if (len1 < len2){
            l1 = fillzero(l1, len2-len1);
        }
        else if (len1 > len2){
            l2 = fillzero(l2, len1-len2);
        }


        ListNode sum_init = new ListNode(0);
        ListNode sum_crt = sum_init;

        int digit_carry = 0;

        while (l1 != null || l2 != null){
            // add digit sum
            int digit_sum = l1.val+l2.val+digit_carry;
            digit_carry = 0;

            // check for carry
            digit_carry = digit_sum/10;
            digit_sum %= 10;

//            if (digit_sum >= 10){
//                digit_sum -= 10;
//                digit_carry = 1;
//            }

            sum_crt.next = new ListNode(digit_sum);
            sum_crt = sum_crt.next;

            // iterate to next digit
            l1 = l1.next;
            l2 = l2.next;
        }
        if (digit_carry == 1) sum_crt.next = new ListNode(1);

        return sum_init.next;
    }
}

class main{
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(1);
//        l2.next.next = new ListNode(4);

        Solution2 solu = new Solution2();
        ListNode result = solu.addTwoNumbers(l1, l2);

        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);

        return;
    }
}
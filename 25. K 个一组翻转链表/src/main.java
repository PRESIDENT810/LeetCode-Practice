class main {
    public static void main(String args[]) {

    }
}

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

class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        return moveFirstK(head, k);
    }

    public ListNode moveFirstK(ListNode node, int k){
        // find the next K node
        ListNode next_head;
        ListNode dummy = new ListNode(-1);
        dummy.next = node;
        ListNode ptr = dummy;
        for (int i=0; i<k; i++){
            ptr = ptr.next;
            if (ptr == null) return node; // not long enough
        }
        next_head = ptr.next;
        // split the linked list to two parts
        // use reverseRange to reverse the first part and use moveFirstK to reverse the second part
        ptr.next = null;
        // recursively reverse the remaining part of the linked list and get the next_head
        next_head = moveFirstK(next_head, k);
        // reverse the part from node to ptr and append next_head to its tail
        node = reverseRange(node, next_head);
        return node;
    }

    public ListNode reverseRange(ListNode start, ListNode next_head){
        // reverse the linked list from start, and append its tail with next_head
        ListNode dummy = new ListNode(-1);
        dummy.next = next_head;
        ListNode ptr = start;
        while (ptr != null){
            ListNode temp = dummy.next;
            dummy.next = ptr;
            ptr = ptr.next;
            dummy.next.next = temp;
        }
        // return the reversed linked list's head
        return dummy.next;
    }
}
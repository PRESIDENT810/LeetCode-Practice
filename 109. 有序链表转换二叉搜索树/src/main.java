import java.util.*;

class main {
    public static void main(String args[]){
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        new Solution109().sortedListToBST(head);

    }
}

class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode ptr = head;
        int idx = 0;
        while (ptr != null) {
            map.put(idx, ptr);
            idx++;
            ptr = ptr.next;
        }
        return recursion(map, 0, idx-1);
    }

    public TreeNode recursion(Map<Integer, ListNode> map, int start, int end){
        if (start > end) return null;
        int mid = (start+end)/2;
        ListNode mid_node = map.get(mid);
        TreeNode mid_treeNode = new TreeNode(mid_node.val);
        mid_treeNode.left = recursion(map, start, mid-1);
        mid_treeNode.right = recursion(map, mid+1, end);
        return mid_treeNode;
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
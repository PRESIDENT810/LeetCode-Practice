import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution337 {
    public int rob(TreeNode root) {
        return Math.max(recursion(root, true), recursion(root, false));
    }

    public int recursion(TreeNode node, boolean can_rob){
        if (node == null) return 0;

        int amt1, amt2;

        // what if I rob this node
        if (can_rob) {
            int L_amt1 = recursion(node.left, false);
            int R_amt1 = recursion(node.right, false);
            amt1 = node.val + L_amt1 + R_amt1;
        }
        else amt1 = 0;
        // this.map1.put(node, amt1);
        // what if I do not rob this node
        int L_amt2 = recursion(node.left, true);
        int R_amt2 = recursion(node.right, true);
        amt2 = L_amt2+R_amt2;
        // this.map2.put(node, amt2);
        return Math.max(amt1, amt2);
    }
}
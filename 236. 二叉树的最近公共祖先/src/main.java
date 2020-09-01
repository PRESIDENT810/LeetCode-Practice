class main {
    public static void main(String args[]) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode resNode = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recursion(root, p, q);
        return this.resNode;
    }

    public int recursion(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return 0;
        int crt = 0;
        if (root == p) crt = 10;
        if (root == q) crt = 1;
        // 00: no p and no q
        // 01: no p but q
        // 10: p but no q
        // 11: p and q
        int n1 = recursion(root.left, p, q);
        int n2 = recursion(root.right, p, q);
        int res = n1+n2+crt;
        if (res == 11 && this.resNode == null) this.resNode = root;
        return res;
    }
}
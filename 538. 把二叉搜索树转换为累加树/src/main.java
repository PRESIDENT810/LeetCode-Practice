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

class Solution538 {
    public TreeNode convertBST(TreeNode root) {
        recursion(root, 0);
        return root;
    }

    public int recursion(TreeNode node, int n) {
        if (node == null) return n;
        int R = recursion(node.right, n);
        node.val += R;
        int L = recursion(node.left, node.val);
        return L;
    }
}
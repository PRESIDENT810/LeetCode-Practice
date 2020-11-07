class main {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        boolean L = root.left == null ? isUnivalTree(root.left) : isUnivalTree(root.left) && root.val == root.left.val;
        boolean R = root.right == null ? isUnivalTree(root.right) : isUnivalTree(root.right) && root.val == root.right.val;
        return L && R;
    }
}
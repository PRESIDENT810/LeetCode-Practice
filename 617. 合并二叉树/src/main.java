class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // if one is null
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        // if both not null
        TreeNode root = t1;
        t1.val += t2.val;
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
}
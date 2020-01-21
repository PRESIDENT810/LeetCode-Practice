public class main {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int min = Integer.MAX_VALUE;

        return minDepth(root, min);
    }

    public int minDepth(TreeNode root, int min) {
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left_depth, right_depth;
        if (root.left != null) left_depth = minDepth(root.left, min);
        else left_depth = Integer.MAX_VALUE;
        if (root.right != null) right_depth = minDepth(root.right, min);
        else right_depth = Integer.MAX_VALUE;

        int crt_depth = Math.min(left_depth, right_depth) + 1;
        return Math.min(min, crt_depth);
    }
}

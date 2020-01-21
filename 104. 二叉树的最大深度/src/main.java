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

class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int max = 0;

        return maxDepth(root, max);
    }

    public int maxDepth(TreeNode root, int max) {
        if (root.left == null && root.right == null){
            if (max < 1) return 1;
        }

        int left_depth, right_depth;
        if (root.left != null) left_depth= maxDepth(root.left, max);
        else left_depth = 0;
        if (root.right != null) right_depth = maxDepth(root.right, max);
        else right_depth = 0;

        int crt_depth =  Math.max(left_depth, right_depth)+1;
        return Math.max(max, crt_depth);
    }
}
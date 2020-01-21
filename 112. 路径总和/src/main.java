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

class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        return recursion(root, sum);
    }

    public boolean recursion(TreeNode root, int sum){
        if (root.left == null && root.right == null) return sum==root.val;

        int current = root.val;

        if (root.left == null) return hasPathSum(root.right, sum-current);
        if (root.right == null) return hasPathSum(root.left, sum-current);

        return hasPathSum(root.left, sum-current) || hasPathSum(root.right, sum-current);
    }
}
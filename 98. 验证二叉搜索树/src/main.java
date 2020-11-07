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

class Solution98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        long min = (long) Integer.MIN_VALUE - 1;
        long max = (long) Integer.MAX_VALUE + 1;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}
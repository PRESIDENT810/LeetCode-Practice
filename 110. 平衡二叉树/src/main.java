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

class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        if (height(root) == -1) return false;
        return true;
    }

    public int height(TreeNode root){
        int left_height;
        int right_height;

        if (root.left == null) left_height = 0;
        else left_height = height(root.left);

        if (root.right == null) right_height = 0;
        else right_height = height(root.right);

        if (left_height == -1 || right_height == -1) return -1;
        if (left_height - right_height >= 2 || right_height - left_height >= 2 ) return -1;

        if (left_height > right_height) return left_height+1;
        return right_height+1;
    }
}
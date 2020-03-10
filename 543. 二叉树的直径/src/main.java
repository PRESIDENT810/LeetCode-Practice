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

class Solution543 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        heightOf(root);
        return this.max-1;
    }

    public int heightOf(TreeNode parent){
        if (parent == null) return 0;

        int leftHeight = heightOf(parent.left);
        int rightHeight = heightOf(parent.right);

        if (leftHeight+rightHeight > this.max) max = leftHeight+rightHeight;
        return Math.max(leftHeight, rightHeight)+1;
    }
}
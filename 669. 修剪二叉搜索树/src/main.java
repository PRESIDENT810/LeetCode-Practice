class main {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        TreeNode left = trimBST(root.left, low, high);
        TreeNode right = trimBST(root.right, low, high);
        if (root.val < low) {
            return right;
        }
        if (root.val > high) {
            return left;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
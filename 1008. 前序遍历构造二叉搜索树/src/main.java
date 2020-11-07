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

class Solution1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        return bstFromPreorder(preorder, 0, preorder.length);
    }

    public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (start >= end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        int mid = -1;
        for (int i = 1; i < end - start; i++) {
            if (preorder[i + start] > preorder[start]) {
                mid = i + start;
                break;
            }
        }
        if (mid != -1) root.left = bstFromPreorder(preorder, start + 1, mid);
        else root.left = bstFromPreorder(preorder, start + 1, end);
        if (mid != -1) root.right = bstFromPreorder(preorder, mid, end);
        else root.right = null;
        return root;
    }
}
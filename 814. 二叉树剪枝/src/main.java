class main {
    public static void main(String args[]){

    }
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

class Solution814 {
    public TreeNode pruneTree(TreeNode root) {
        if (!detect(root)) return null;
        return root;
    }

    public boolean detect(TreeNode root){
        // return true if the subtree contains one
        if (root == null) return false;
        boolean res_L = detect(root.left);
        boolean res_R = detect(root.right);
        if (!res_L) root.left = null;
        if (!res_R) root.right = null;
        return (root.val == 1) || res_L || res_R;
    }
}
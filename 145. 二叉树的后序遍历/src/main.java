import java.util.*;

class main {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        new Solution145().postorderTraversal(root);
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

class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        TreeNode last = new TreeNode(-1);
        List<Integer> res = new LinkedList<>();
        while (stack.size() != 0) {
            TreeNode first = stack.peekFirst();
            if (first == null) return res;
            if (first.left == last || first.right == last) {
                res.add(first.val);
                last = stack.pollFirst();
                continue;
            }
            if (first.right != null) stack.addFirst(first.right);
            if (first.left != null) stack.addFirst(first.left);
            if (first.left == null && first.right == null) {
                res.add(first.val);
                last = stack.pollFirst();
            }
        }
        return res;
    }
}
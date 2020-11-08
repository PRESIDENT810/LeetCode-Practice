import java.util.*;

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

class Solution113 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> path = new LinkedList<>();
        if (root == null) return this.res;
        recursion(root, root.val, sum, path);
        return this.res;
    }

    public void recursion(TreeNode root, int current, int sum, LinkedList<Integer> path) {
        if (root.left == null && root.right == null) {
            if (current == sum) {
                LinkedList<Integer> path_copy = new LinkedList<>();
                path_copy.addAll(path);
                path_copy.add(root.val);
                this.res.add(path_copy);
            }
            return;
        }
        path.addLast(root.val);
        if (root.left != null) recursion(root.left, current + root.left.val, sum, path);
        if (root.right != null) recursion(root.right, current + root.right.val, sum, path);
        path.removeLast();
    }
}
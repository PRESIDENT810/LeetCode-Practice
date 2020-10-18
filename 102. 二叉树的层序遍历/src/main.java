import java.util.*;

class main {
    public static void main(String args[]){

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> q1 = new LinkedList<>(); // for node
        Queue<Integer> q2 = new LinkedList<>(); // for level
        q1.add(root);
        q2.add(0);
        while (q1.size() != 0) {
            TreeNode out = q1.poll();
            int level = q2.poll();
            if (out.left != null) {
                q1.add(out.left);
                q2.add(level + 1);
            }
            if (out.right != null) {
                q1.add(out.right);
                q2.add(level + 1);
            }
            if (res.size() <= level) {
                res.add(new LinkedList<Integer>());
            }
            res.get(level).add(out.val);
        }
        return res;
    }
}
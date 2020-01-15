import java.util.*;

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

class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        q1.add(root);
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q2.add(root);

        while (!q1.isEmpty()){
            TreeNode current1 = q1.remove();
            TreeNode current2 = q2.remove();

            if (current1.val != current2.val) return false;

            if (current1.left != null & current2.right == null) return false;
            if (current1.right != null & current2.left == null) return false;

            if (current1.left != null) q1.add(current1.left);
            if (current2.right != null) q2.add(current2.right);

            if (current1.right != null) q1.add(current1.right);
            if (current2.left != null) q2.add(current2.left);
        }

        return true;
    }
}

import java.util.LinkedList;
import java.util.Queue;

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

class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;

        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        q1.add(p);
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q2.add(q);

        while (!q1.isEmpty()) {
            TreeNode current1 = q1.remove();
            TreeNode current2 = q2.remove();

            if (current1.val != current2.val) return false;

            if (current1.left != null & current2.left == null) return false;
            if (current1.right != null & current2.right == null) return false;

            if (current1.left != null) q1.add(current1.left);
            if (current2.left != null) q2.add(current2.left);

            if (current1.right != null) q1.add(current1.right);
            if (current2.right != null) q2.add(current2.right);
        }

        return true;
    }
}
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

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return check(p, q);
    }

    public boolean check(TreeNode p, TreeNode q){
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;

        if (p.val != q.val) return false;

        if (p.left != null && p.right != null) return check(p.left, q.left) && check(p.right, q.right);

        if (p.left == null && p.right != null) {
            if (q.left != null) return false;
            return check(p.right, q.right);
        }

        if (p.right == null && p.left != null) {
            if (q.right != null)  return false;
            return check(p.left, q.left);
        }

        return q.left == null && q.right == null;

    }
}
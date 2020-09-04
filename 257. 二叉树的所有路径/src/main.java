import java.util.*;

class main {
    public static void main(String args[]) {

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

class Solution257 {
    public List<String> res;
    public TreeNode root;

    public List<String> binaryTreePaths(TreeNode root) {
        this.res = new LinkedList<>();
        this.root = root;
        if (root != null) recursion(new StringBuilder(), root);
        return this.res;
    }

    public void recursion(StringBuilder sb, TreeNode node){
        if (node.left == null && node.right == null) {
            StringBuilder new_sb = new StringBuilder(sb);
            if (node != this.root) new_sb.append("->");
            new_sb.append(node.val);
            this.res.add(new String(new_sb));
            return;
        }
        StringBuilder new_sb = new StringBuilder(sb);
        if (node != this.root) new_sb.append("->");
        new_sb.append(node.val);
        if (node.left != null) recursion(new_sb, node.left);
        if (node.right != null) recursion(new_sb, node.right);
    }
}

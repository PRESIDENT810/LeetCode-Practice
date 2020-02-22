import java.util.*;

public class main {
    public static void main(String args[]) {
        new Solution22().generateParenthesis(2);
    }
}

class Node {
    Node left;
    Node right;
    int l_cnt;
    int r_cnt;
    int layer;
    StringBuilder str_builder = new StringBuilder();
}

class Solution22 {
    List<String> ans = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        Node root = new Node();
        root.layer = 1;
        root.l_cnt = 1;
        root.str_builder = new StringBuilder("(");
        root = recursion(root, 2 * n);
        return this.ans;
    }

    public Node recursion(Node parent, int depth) {
        if (parent.layer == depth) {
            this.ans.add(new String(parent.str_builder));
            return parent;
        }

        Node l_child = new Node();
        l_child.l_cnt = parent.l_cnt + 1;
        l_child.r_cnt = parent.r_cnt;
        l_child.layer = parent.layer + 1;
        l_child.str_builder = new StringBuilder(parent.str_builder).append('(');
        Node r_child = new Node();
        r_child.l_cnt = parent.l_cnt;
        r_child.r_cnt = parent.r_cnt + 1;
        r_child.layer = parent.layer + 1;
        r_child.str_builder = new StringBuilder(parent.str_builder).append(')');

        if (parent.l_cnt == depth / 2) {
            parent.right = recursion(r_child, depth);
        } else if (parent.l_cnt == parent.r_cnt) {
            parent.left = recursion(l_child, depth);
        } else {
            parent.left = recursion(l_child, depth);
            parent.right = recursion(r_child, depth);
        }
        return parent;
    }
}
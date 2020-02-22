import java.util.*;

public class main {
    public static void main(String args[]) {
        new Solution22().generateParenthesis(2);
    }
}

class Node {
    Node parent;
    Node left;
    Node right;
    int l_cnt;
    int r_cnt;
    int layer;
    char parenthesis;
}

class Solution22 {
    List<Node> leaves = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        Node root = new Node();
        root.layer = 1;
        root.l_cnt = 1;
        root = recursion(root, 2 * n);
        List<String> ans = backtrack(root);
        return ans;
    }

    public List<String> backtrack(Node node) {
        List<String> ans = new LinkedList<>();
        StringBuilder str;
        for (Node leave : this.leaves){
            str = new StringBuilder();
            while (leave.parent != null){
                str.append(leave.parenthesis);
                leave = leave.parent;
            }
            str.append(')');
            ans.add(new String(str));
        }
        return ans;
    }

    public Node recursion(Node parent, int depth) {
        if (parent.layer == depth) {
            this.leaves.add(parent);
            return parent;
        }

        Node l_child = new Node();
        l_child.parent = parent;
        l_child.l_cnt = parent.l_cnt + 1;
        l_child.r_cnt = parent.r_cnt;
        l_child.layer = parent.layer + 1;
        l_child.parenthesis = ')';
        Node r_child = new Node();
        r_child.parent = parent;
        r_child.l_cnt = parent.l_cnt;
        r_child.r_cnt = parent.r_cnt + 1;
        r_child.layer = parent.layer + 1;
        r_child.parenthesis = '(';

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
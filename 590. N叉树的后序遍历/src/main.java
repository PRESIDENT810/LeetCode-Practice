import java.util.*;

class main {
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution590 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            if (node.children == null) {
                res.add(node.val);
                continue;
            }
            stack.push(node);
            Collections.reverse(node.children);
            stack.addAll(node.children);
            node.children = null;
        }
        return res;
    }
}
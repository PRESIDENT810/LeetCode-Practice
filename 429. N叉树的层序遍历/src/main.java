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

class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        List<Integer> current_level = new LinkedList<>();
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue1.offer(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()){
            if (queue1.isEmpty()){
                Queue<Node> temp = queue1;
                queue1 = queue2;
                queue2 = temp;
                res.add(current_level);
                current_level = new LinkedList<>();
            }
            Node node = queue1.poll();
            queue2.addAll(node.children);
            current_level.add(node.val);
        }
        res.add(current_level);
        return res;
    }
}
class main {
    public static void main(String args[]) {
        Node root = new Node(4);
        Node left = new Node(2);
        Node right = new Node(5);
        root.left = left;
        root.right = right;
        left.left = new Node(1);
        left.right = new Node(3);
        Node res = new Solution剑指36().treeToDoublyList(root);
        System.out.print(res);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class EndPoints {
    EndPoints(Node L_endPoint, Node R_endPoint) {
        this.L_endPoint = L_endPoint;
        this.R_endPoint = R_endPoint;
    }

    public Node L_endPoint;
    public Node R_endPoint;
}

class Solution剑指36 {
    Node dummy, crt;

    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        this.dummy = new Node(-1);
        this.crt = this.dummy;
        dfs(root);
        // while (dummy != null){
        //     System.out.print(dummy.val);
        //     dummy = dummy.right;
        // }
        crt.right = dummy.right;
        dummy.right.left = crt;
        return this.dummy.right;
    }

    public void dfs(Node root) {
        if (root == null) return;
        // make left child tree a double list and append on crt
        dfs(root.left);
        this.crt.right = root;
        root.left = this.crt;
        this.crt = root;
        dfs(root.right);
    }
}
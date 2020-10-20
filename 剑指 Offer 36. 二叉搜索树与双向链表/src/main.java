class main {
    public static void main(String args[]){
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

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class EndPoints{
    EndPoints(Node L_endPoint, Node R_endPoint){
        this.L_endPoint = L_endPoint;
        this.R_endPoint = R_endPoint;
    }
    public Node L_endPoint;
    public Node R_endPoint;
}

class Solution剑指36 {
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        EndPoints endPoints = recursion(root);
        Node L = endPoints.L_endPoint;
        Node R = endPoints.R_endPoint;
        L.left = R;
        R.right = L;
        return L;
    }

    public EndPoints recursion(Node root){
        // handle left child
        Node LL, LR, RL, RR;
        if (root.left == null){
            LL = root;
        }
        else {
            EndPoints L_EndPoints = recursion(root.left);
            LL = L_EndPoints.L_endPoint;
            LR = L_EndPoints.R_endPoint;
            LR.right = root;
            root.left = LR;
        }
        // handle right child
        if (root.right == null){
            RR = root;
        }
        else {
            EndPoints R_EndPoints = recursion(root.right);
            RL = R_EndPoints.L_endPoint;
            RR = R_EndPoints.R_endPoint;
            RL.left = root;
            root.right = RL;
        }
        return new EndPoints(LL, RR);
    }
}
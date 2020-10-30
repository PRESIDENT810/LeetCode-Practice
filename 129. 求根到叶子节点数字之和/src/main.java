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

class Solution129 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        recursion(root, new LinkedList<>());
        return this.sum;
    }

    public void recursion(TreeNode node, LinkedList<Integer> list){
        list.addFirst(node.val);
        // if both left and right child is null, then add it to sum
        if (node.left == null && node.right == null){
            clear(list);
        }
        // left not null
        if (node.left != null){
            recursion(node.left, list);
        }
        // right not null
        if (node.right != null){
            recursion(node.right, list);
        }
        list.removeFirst();
        return;
    }

    public void clear(LinkedList<Integer> list){
        int base = 1;
        for (int i: list){
            this.sum += i*base;
            base *= 10;
        }
    }
}
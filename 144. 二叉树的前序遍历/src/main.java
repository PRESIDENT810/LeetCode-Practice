import java.util.*;

class main {
    public static void main(String args[]){

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

class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode temp;
        while (stack.size() != 0) {
            temp = stack.pop();
            if (temp == null) continue;
            res.add(temp.val);
            stack.add(temp.right);
            stack.add(temp.left);
        }
        return res;
    }
}
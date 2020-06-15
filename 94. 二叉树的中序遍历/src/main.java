import java.util.*;

class main {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();
        TreeNode crt = root;
        while (!stack.empty() || crt != null){
            while (crt != null){
                stack.add(crt);
                crt = crt.left;
            }
            crt = stack.pop();
            res.add(crt.val);
            crt = crt.right;
        }
        return res;
    }
}
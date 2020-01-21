import com.sun.source.tree.Tree;

import java.util.*;

public class main {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new LinkedList<>();

        Queue<TreeNode> tree_queue = new LinkedList<>();
        Queue<Integer> level_queue = new LinkedList<>();

        tree_queue.add(root);
        level_queue.add(0);
        int current_level = 0;
        LinkedList<Integer> current_list = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();

        while (!tree_queue.isEmpty()) {
            TreeNode current_node = tree_queue.remove();
            int level = level_queue.remove();

            // add children to the tree_queue & add children level to the level_queue
            if (current_node.left != null) {
                tree_queue.add(current_node.left);
                level_queue.add(level + 1);
            }
            if (current_node.right != null) {
                tree_queue.add(current_node.right);
                level_queue.add(level + 1);
            }

            // if go to a new level, use a new list
            if (level != current_level) {
                ans.add(current_list);
                current_list = new LinkedList<>();
                current_list.add(current_node.val);
                current_level = level;
            } else {
                current_list.add(current_node.val);
            }
        }
        ans.add(current_list);
        Collections.reverse(ans);
        return ans;
    }
}

import java.util.HashMap;
import java.util.Map;

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

class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        Map<Integer, Integer> inorder_map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorder_map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, inorder_map);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int pre_L, int pre_R, int in_L, int in_R, Map<Integer, Integer> inorder_map) {
        // pre_L, pre_R defines the range in preorder; in_L, in_R defines the range in inorder

        if (pre_L > pre_R) return null;
        if (pre_L == pre_R) return new TreeNode(preorder[pre_L]);

        int root_val = preorder[pre_L];

        // the first element in preorder range is the root
        TreeNode root = new TreeNode(root_val);
        // find the position of root in inorder range
        int i = inorder_map.get(root_val);
        // left child tree
        int left_child_len = i - in_L;
        root.left = buildTree(preorder, inorder, pre_L + 1, pre_L + left_child_len, in_L, i - 1, inorder_map);
        // right child tree
        int right_child_len = (in_R - in_L) - left_child_len;
        root.right = buildTree(preorder, inorder, pre_L + left_child_len + 1, pre_L + left_child_len + right_child_len, i + 1, in_R, inorder_map);
        return root;
    }
}
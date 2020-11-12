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

class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder,
                              int inStart, int inEnd,
                              int postStart, int postEnd) {
        int root_value = postorder[postEnd];
        // find left subtree and right subtree in inorder array
        int inMid = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root_value) {
                inMid = i;
                break;
            }
        }
        // find left subtree and right subtree in postorder array
        int left_len = inMid - inStart;
        int right_len = inEnd - inMid;

        TreeNode rootNode = new TreeNode(root_value);
        rootNode.left = left_len > 0 ? buildTree(inorder, postorder, inStart, inMid - 1, postStart, postEnd - right_len - 1) : null;
        rootNode.right = right_len > 0 ? buildTree(inorder, postorder, inMid + 1, inEnd, postEnd - right_len, postEnd - 1) : null;
        return rootNode;
    }
}
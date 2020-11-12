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

class Solution889 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) return null;
        return constructFromPrePost(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post,
                                         int preStart, int preEnd,
                                         int postStart, int postEnd) {
        // System.out.printf("%d, %d, %d, %d\n", preStart, preEnd, postStart, postEnd);
        if (preStart > preEnd || postStart > postEnd) return null; // deal with null tree
        if (preStart == preEnd) return new TreeNode(pre[preStart]); // deal with tree with a single node

        int root_value = pre[preStart];
        TreeNode rootNode = new TreeNode(root_value);

        int left_child = pre[preStart + 1];
        int right_child = post[postEnd - 1];
        if (left_child == right_child) { // treat it as only left tree
            rootNode.left = constructFromPrePost(pre, post, preStart + 1, preEnd, postStart, postEnd - 1);
            return rootNode;
        }

        int postMid = -99; // right edge of left subtree in postorder
        // find left_root in postorder
        for (int i = postStart; i <= postEnd; i++) {
            if (post[i] == left_child) {
                postMid = i;
                break;
            }
        }
        // find right_root in preorder
        int preMid = -99; // left edge of right subtree in preorder
        for (int i = preStart; i <= preEnd; i++) {
            if (pre[i] == right_child) {
                preMid = i;
                break;
            }
        }

        rootNode.left = constructFromPrePost(pre, post, preStart + 1, preMid - 1, postStart, postMid);
        rootNode.right = constructFromPrePost(pre, post, preMid, preEnd, postMid + 1, postEnd - 1);
        return rootNode;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class main {
    public static void main(String args[]){
        int[] arr = {-10,-3,0,5,9};
        TreeNode root = new Solution108().sortedArrayToBST(arr);
    }
}

class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0, nums.length);
    }

    public TreeNode recursion(int[] nums, int left_idx, int right_idx){
        if (left_idx == nums.length || left_idx == right_idx) return null;
        if (left_idx+1 == right_idx) return new TreeNode(nums[left_idx]);

        int mid_idx = (left_idx+right_idx)/2;

        TreeNode root = new TreeNode(nums[mid_idx]);
        root.left = recursion(nums, left_idx, mid_idx);
        root.right = recursion(nums, mid_idx+1, right_idx);

        return root;
    }
}
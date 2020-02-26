public class main {
    public static void main(String args[]) {
        int[] arr = {1, 5, 1};
        new Solution31().nextPermutation(arr);
    }
}

class Solution31 {
    public void nextPermutation(int[] nums) {
        // find the last decreasing subarray
        int decreasing_idx = 0;
        int last = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > last) decreasing_idx = i;
            last = nums[i];
        }

        int temp;
        if (decreasing_idx != 0) {
            // find the element to be switched
            int in_idx = decreasing_idx - 1;
            int out_idx = nums.length - 1;
            for (int i = decreasing_idx; i < nums.length; i++) {
                if (nums[i] > nums[in_idx]) out_idx = i;
            }
            // switch two elements
            temp = nums[in_idx];
            nums[in_idx] = nums[out_idx];
            nums[out_idx] = temp;
        }

        // reverse the subarray
        for (int i = 0; i < (nums.length - decreasing_idx) / 2; i++) {
            temp = nums[decreasing_idx + i];
            nums[decreasing_idx + i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }
}
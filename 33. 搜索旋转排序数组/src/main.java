public class main {
    public static void main(String args[]) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.print(new Solution33().search(arr, 0));
    }
}


class Solution33 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int L = 0;
        int R = nums.length - 1;
        int M = (L + R) / 2;

        while (true) {
            if (L + 1 >= R) {
                if (nums[L] == target) return L;
                if (nums[R] == target) return R;
                return -1;
            }

            if (nums[L] <= nums[M]) {
                if (nums[L] <= target && nums[M] >= target) R = M;
                else L = M;
            } else {
                if (nums[M] <= target && nums[R] >= target) L = M;
                else R = M;
            }
            M = (L + R) / 2;
        }
    }
}

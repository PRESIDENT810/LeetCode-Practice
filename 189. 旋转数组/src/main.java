import java.util.Arrays;

public class main {
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        new Solution189().rotate(arr, 4);
        System.out.print(Arrays.toString(arr));
    }
}

class Solution189 {
    public void reverse(int[] nums, int start, int end){
        int temp;
        while (start != end && start != end+1) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
}
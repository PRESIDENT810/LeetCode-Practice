import java.util.*;

public class main {
    public static void main(String args[]){
        int[] arr = {0,1,2};
        System.out.print(new Solution16().threeSumClosest(arr, 3));
    }
}

class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        List<List<Integer>> all_ans = new LinkedList<>();

        Arrays.sort(nums);
        int left = 0;
        int mid = 1;
        int right = 2;
        int sum, min = 999;
        int sign = 1;

        while (mid != nums.length - 1) {
            if (left == -1 || right == nums.length) {
                mid++;
                left = mid - 1;
                right = mid + 1;
                continue;
            }

            sum = nums[left] + nums[mid] + nums[right];
            if (sum == target) {
                return target;
            } else if (sum > target) {
                left--;
                if (sum-target < min) {min = sum-target; sign = 1;}
            } else {
                if (target-sum < min) {min = target-sum; sign = -1;}
                right++;
            }
        }

        return target+sign*min;
    }
}
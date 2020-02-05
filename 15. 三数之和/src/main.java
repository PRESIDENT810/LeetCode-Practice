import java.util.*;

public class main {
    public static void main(String args[]){
        int[] arr = {3,0,-2,-1,1,2};
        List<List<Integer>> all_ans = new Solution15().threeSum(arr);
    }
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> all_ans = new LinkedList<>();
        Set<List<Integer>> ans_set = new HashSet<>();
        if (nums.length < 3) return all_ans;

        Arrays.sort(nums);
        int left = 0;
        int mid = 1;
        int right = 2;
        int sum;

        while (mid != nums.length-1){
            if (left == -1 || right == nums.length) {
                mid++; left = mid-1; right = mid+1;
                continue;
            }

            sum = nums[left]+nums[mid]+nums[right];
            if (sum == 0) {
                LinkedList<Integer> ans = new LinkedList<>();
                ans.add(nums[left]); ans.add(nums[mid]);ans.add(nums[right]);
                ans_set.add(ans);
                left--; right++;
                continue;
            }
            else if (sum > 0) left--;
            else right++;
        }

        all_ans.addAll(ans_set);
        return all_ans;
    }
}

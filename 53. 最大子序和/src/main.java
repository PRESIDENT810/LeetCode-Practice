public class main {
    public static void main(String args[]){
        Solution53 solu = new Solution53();
        int[] nums = {1};
        System.out.print(solu.maxSubArray(nums));
    }
}

class Solution53 {
    public int maxSubArray(int[] nums) {
        boolean ontail = false;
        int max = nums[0];
        int[] max_arr = new int[nums.length];
        max_arr[0] = max;

        for (int i=1; i<nums.length; i++){
            if (nums[i] > nums[i]+max) max = nums[i];
            else max += nums[i];
            max_arr[i] = max;
        }

        int result = max_arr[0];
        for (int i=0; i<max_arr.length; i++){
            if (max_arr[i] > result) result = max_arr[i];
        }

        return result;
    }
}

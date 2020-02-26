public class main {
}

class Solution283 {
    public void moveZeroes(int[] nums) {
        int last_idx = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] != 0) {
                nums[last_idx] = nums[i];
                if (i != last_idx) nums[i] = 0;
                last_idx++;
            }
        }
    }
}
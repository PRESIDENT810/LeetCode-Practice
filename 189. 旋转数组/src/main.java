public class main {
}

class Solution {
    public void move(int[] nums){
        int last = nums[0];
        int temp;
        for (int i=1; i<nums.length; i++){
            temp = nums[i];
            nums[i] = last;
            last = temp;
        }
        nums[0] = last;
    }

    public void rotate(int[] nums, int k) {
        for (int i=0; i<k; i++) move(nums);
    }
}
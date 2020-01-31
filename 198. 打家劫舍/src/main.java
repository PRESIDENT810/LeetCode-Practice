public class main {
}

class Solution198 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] values = new int[nums.length];
        int rob1, rob2;

        for (int i=0; i<nums.length; i++){
            if (i==0) values[i] = nums[0];
            else if (i==1) values[i] = nums[1] > nums[0] ? nums[1] : nums[0];
            else {
                rob1 = values[i-2]+nums[i];
                rob2 = values[i-1];
                values[i] = rob1 > rob2 ? rob1 : rob2;
            }
        }
        return values[nums.length-1];
    }
}
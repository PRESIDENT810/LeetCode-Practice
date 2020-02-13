public class main {
}

class Solution268 {
    public int missingNumber(int[] nums) {
        int ans = nums.length;
        for (int i=0; i<nums.length; i++){
            ans = ans ^ i;
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
import java.util.*;

public class main {
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) return false;
        Arrays.sort(nums);
        int last_num = nums[0]-1;

        for (int num: nums){
            if (last_num == num) return true;
            last_num = num;
        }
        return false;
    }
}

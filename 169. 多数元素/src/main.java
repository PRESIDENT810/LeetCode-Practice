import java.util.*;

public class main {
}

class Solution169 {
    public int majorityElement(int[] nums) {
        int count = 1;
        int candidate = nums[0];

        for (int i=1; i<nums.length; i++) {
            if (count == 0) candidate = nums[i];

            if (nums[i] != candidate) count--;
            else count++;
        }
        return candidate;
    }
}

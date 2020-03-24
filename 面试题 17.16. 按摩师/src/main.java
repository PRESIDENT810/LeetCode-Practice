import java.util.*;

public class main {
}

class Solution_17_16 {
    Map<Integer, Integer> map = new HashMap<>();

    public int massage(int[] nums) {
        if (nums.length == 0) return 0;
        return max(nums, nums.length - 1);
    }

    public int max(int[] nums, int end) {
        if (this.map.containsKey(end)) return this.map.get(end);

        if (end == 0) return nums[0];
        if (end == 1) return Math.max(nums[0], nums[1]);

        int n1 = nums[end] + max(nums, end - 2);
        int n2 = max(nums, end - 1);
        int res = Math.max(n1, n2);
        this.map.put(end, res);
        return res;
    }
}
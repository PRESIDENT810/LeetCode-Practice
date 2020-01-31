import java.util.*;

public class main {
}

class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map map = new HashMap();

        for (int i=0; i<nums.length; i++){
            if (map.containsKey(nums[i])) {
                int j = (int)map.get(nums[i]);
                if (j-i <= k || i-j <= k) return true;
            }
            else map.put(nums[i], i);
        }
        return false;
    }
}
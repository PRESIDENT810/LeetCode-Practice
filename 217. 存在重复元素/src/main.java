import java.util.*;

public class main {
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set set = new HashSet();

        for (int num: nums){
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}

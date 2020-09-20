import java.util.*;

class main {
    public static void main(String[] args){
        Solution1 solu = new Solution1();
        int[] nums = {2,7,11,15};
        int[] result = solu.twoSum(nums, 9);
        Queue<Integer> q = new LinkedList<>();

    }
}

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map m = new HashMap();

        for (int idx=0; idx<nums.length; idx++){
            // check whether contain this key
            if (m.containsKey(nums[idx])){
                result[0] = idx;
                result[1] = (int) m.get(nums[idx]);
                return result;
            }
            // no such key
            int complement = target-nums[idx];
            m.put(complement, idx);
        }
        return result;
    }
}
import java.util.*;

public class main {
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> negs = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();

        for (int num: nums){
            if (num <= 0) negs.add(num);
        }

        for (Integer neg: negs){

        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map m = new HashMap();

        for (int idx=0; idx<nums.length; idx++){
            // check whether contain this key
            if (m.containsKey(nums[idx])){
                List<Integer> ans = new LinkedList<>();
                ans.add(target);
                ans.add()
            }
            // no such key
            int complement = target-nums[idx];
            m.put(complement, idx);
        }
        return result;
    }
}

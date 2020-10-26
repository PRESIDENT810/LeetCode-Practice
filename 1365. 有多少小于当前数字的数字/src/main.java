import java.util.*;

class main {
    public static void main(String args[]){
        int[] arr = {8,1,2,2,3};
        new Solution1365().smallerNumbersThanCurrent(arr);
    }
}

class Solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] buckets = new int[101];
        for (int n: nums) buckets[n] = buckets[n]+1;
        int cnt = 0;
        for (int i=0; i<buckets.length; i++){
            int temp = buckets[i];
            buckets[i] = cnt;
            cnt += temp;
        }
        for (int i=0; i<nums.length; i++) nums[i] = buckets[nums[i]];
        return nums;
    }
}

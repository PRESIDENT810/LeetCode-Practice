import java.util.*;

class main {
    public static void main(String args[]){
        int[] arr = {0,0,1,1,1,1,2,3,3};
        new Solution80().removeDuplicates(arr);
    }
}

class Solution80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        int last = nums[0];
        for (int i=0; i<nums.length; i++){
            if (nums[i] == last){ // same number
                cnt++;
            }
            else{ // different number
                map.put(last, cnt);
                last = nums[i];
                cnt = 1;
            }
        }
        map.put(last, cnt);
        // for (int key: map.keySet())System.out.printf("Key: %d, value: %d\n", key, map.get(key));
        int offset = 0;
        last = nums[0];
        int value = map.get(last);
        for (int i=0; i<nums.length; i++){
            if (nums[i] != last){ // different number
                value = map.get(last);
                if (value > 2) offset += value-2; // update offset
                last = nums[i]; // update last to current number
            }
            move(nums, i, offset); // move nums[i] back offset
        }
        // do it again in case the last section is duplicated
        value = map.get(last);
        if (value > 2) offset += value-2; // update offset
        return nums.length-offset;
    }

    public void move(int[] nums, int idx, int offset){
        if (offset == 0) return;
        nums[idx-offset] = nums[idx];
    }
}
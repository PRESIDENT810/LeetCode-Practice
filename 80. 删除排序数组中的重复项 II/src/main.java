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
        int offset = 0;
        int last = nums[0];
        for (int i=0; i<nums.length; i++){
            if (nums[i] == last){ // same number
                cnt++;
            }
            else{ // different number
                if (cnt > 2) offset += cnt-2; // update offset
                last = nums[i];
                cnt = 1;
            }
            move(nums, i, offset); // move nums[i] back offset
        }
        if (cnt > 2) offset += cnt-2; // update offset
        return nums.length-offset;
    }

    public void move(int[] nums, int idx, int offset){
        if (offset == 0) return;
        nums[idx-offset] = nums[idx];
    }
}
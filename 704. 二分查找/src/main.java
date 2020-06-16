public class main {
}

class Solution704 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int m;
        while (l != r) {
            m = (l+r)/2;
            if (nums[m] > target) r=m;
            else if (nums[m] == target) return m;
            else l=m+1;
        }
        if (nums[l] == target) return l;
        return -1;
    }
}
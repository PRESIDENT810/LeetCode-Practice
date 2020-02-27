public class main {
    public static void main(String args[]){
        int[] arr = {0,1,1,2,2,3};
        System.out.print(new Solution34().findLast(arr, 2));
    }
}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        if (first == -1) return new int[] {-1, -1};
        int last = findLast(nums, target);
        return new int[] {first, last};
    }

    public int findFirst(int[] nums, int target){
        int L = 0;
        int R = nums.length-1;
        int M = L+(R-L)/2;

        while (L <= R){
            if (L == R) return nums[L] == target? L : -1;

            if (nums[M] < target) L = M+1;
            else R = M;
            M = L+(R-L)/2;
        }
        return -1;
    }

    public int findLast(int[] nums, int target){
        int L = 0;
        int R = nums.length-1;
        int M = L+(R-L)/2;

        while (L <= R){
            if (L == R) return nums[L] == target? L : -1;

            if (nums[M] <= target) L = M;
            else R = M-1;
            M = R+(L-R)/2;
        }
        return -1;
    }
}
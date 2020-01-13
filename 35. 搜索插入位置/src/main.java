public class main {
    public static void main(String args[]){
        Solution35 solu = new Solution35();
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.print(solu.searchInsert(nums, target));
    }
}

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int head = 0;
        int tail = nums.length;
        int mid = (int) (head+tail)/2;;

        while (tail - head > 1){
            mid = (int) (head+tail)/2;

            if (nums[mid] > target){ // target in first half
                tail = mid;
            }
            else if (nums[mid] < target){ // target in last half
                head = mid;
            }
            else return mid;
        }

        if (nums[head] < target) return head+1;
        else return head;
    }
}


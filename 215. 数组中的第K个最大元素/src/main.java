import java.util.*;

class main{
    public static void main(String args[]){
        int[] nums = {3,2,1,5,6,4};
        Solution215 solu = new Solution215();
        int res = solu.findKthLargest(nums, 2);
        System.out.print(res);
    }
}

class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length-1;
        int res = partition(nums, start, end);

        int target = nums.length-k;
        while (res != target){
            if (res > target) {
                end = res-1;
                res =  partition(nums, start, end);
            }
            else {
                start = res+1;
                res = partition(nums, start, end);
            }
        }
        return nums[res];
    }

    public int partition(int[] nums, int start, int end){
        if (start == end) return start;

        int pivot = nums[start];
        int left_ptr = start+1;
        int right_ptr = end;
        while (true){
            while (left_ptr < right_ptr && nums[right_ptr] >= pivot){
                right_ptr--;
            }
            while (left_ptr < right_ptr && nums[left_ptr] < pivot){
                left_ptr++;
            }
            if (left_ptr >= right_ptr) break;
            swap(nums, left_ptr, right_ptr);
        }
        if (nums[left_ptr] >= pivot) return start;
        swap(nums, start, left_ptr);
        return left_ptr;
    }

    public void swap(int[] nums, int left_ptr, int right_ptr){
        int temp = nums[left_ptr];
        nums[left_ptr] = nums[right_ptr];
        nums[right_ptr] = temp;
    }
}
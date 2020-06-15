class main {
    public static void main(String args[]) {
        int[] arr = {-2,3,-5};
        new Solution912().sortArray(arr);
        for (int num : arr) System.out.print(num);
    }
}

class Solution912 {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int boundary = partition(nums, start, end);
        quickSort(nums, start, boundary-1);
        quickSort(nums, boundary+1, end);
    }

    public int partition(int[] nums, int start, int end){
        int pivot = nums[start];
        int l = start+1;
        int r = end;
        while (true){
            while (l<r && nums[r] >= pivot) r--;
            while (l<r && nums[l] < pivot) l++;
            if (l == r) break;
            swap(nums, l, r);
        }
        if (nums[l] >= pivot) return start;
        nums[start] = nums[l];
        nums[l] = pivot;
        return l;
    }

    public void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
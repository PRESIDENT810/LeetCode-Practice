public class main {
    public static void main(String args[]){
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        Solution88 solu = new Solution88();
        solu.merge(arr1, 3, arr2, 3);
    }
}

class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m - 1;
        int ptr2 = n - 1;

        for (int i = 0; i < nums1.length; i++) {
            int idx = nums1.length - i - 1;

            if (ptr1 == -1) {
                nums1[idx] = nums2[ptr2];
                ptr2--;
                continue;
            }
            else if (ptr2 == -1) {
                nums1[idx] = nums1[ptr1];
                ptr1--;
                continue;
            }

            if (nums1[ptr1] > nums2[ptr2]) {
                nums1[idx] = nums1[ptr1];
                ptr1--;
            } else {
                nums1[idx] = nums2[ptr2];
                ptr2--;
            }

        }
    }
}

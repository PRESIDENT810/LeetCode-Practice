import java.util.*;

class main {
    public static void main(String args[]){

    }
}

class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // switch so nums1 is always longer

        if (nums1.length < nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i: nums2) set2.add(i);
        for (int i: nums1){
            if (set2.contains(i)) set1.add(i);
        }
        int[] res = new int[set1.size()];
        int idx = 0;
        for (int i: set1){
            res[idx] = i;
            idx++;
        }
        return res;
    }
}
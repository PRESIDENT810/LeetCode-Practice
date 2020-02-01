import java.util.*;

class main {
    public static void main(String[] args) {
        Solution3 solu = new Solution3();
        int result = solu.lengthOfLongestSubstring("au");
        System.out.println(result);
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        if (arr.length == 0) return 0;
        int ptr1 = 0;
        int ptr2 = 0;

        int max = 1;
        int[] map = new int[128];
        for (int i=0; i<128; i++) map[i] = -1;

        while (ptr2 != arr.length) {
            if (map[arr[ptr2]-' '] >= ptr1) ptr1 = map[arr[ptr2]-' '] + 1;
            map[arr[ptr2]-' '] = ptr2;
            if (ptr2 - ptr1 + 1 > max) max = ptr2 - ptr1 + 1;
            ptr2++;
        }
        return max;
    }
}
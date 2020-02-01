import java.util.*;

class main {
    public static void main(String[] args) {
        Solution3 solu = new Solution3();
        int result = solu.lengthOfLongestSubstring("abcabcbb");
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
        Map map = new HashMap();

        while (ptr2 != arr.length) {
            if (map.containsKey(arr[ptr2])){
                if ((int) map.get(arr[ptr2]) >= ptr1) ptr1 = (int) map.get(arr[ptr2])+1;
            }
            map.put(arr[ptr2], ptr2);
            if (ptr2 - ptr1 + 1 > max) max = ptr2-ptr1+1;
            ptr2++;
        }
        return max;
    }
}
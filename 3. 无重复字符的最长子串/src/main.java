import java.util.*;
import java.math.*;

class main {
    public static void main(String[] args) {
        Solution3 solu = new Solution3();
        int result = solu.lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
    }
}

class Solution3 {
    public boolean LongestOnTheEnd(String s, int len) {
        String end_sub = s.substring(s.length() - len);
        Set end_set = new HashSet();

        for (int i = 0; i < len; i++) {
            if (end_set.contains(end_sub.charAt(i))) return false;
            end_set.add(end_sub.charAt(i));
        }
        return true;
    }

    public Set EndSet(String s, int len) {
        String end_sub = s.substring(s.length() - len);
        Set end_set = new HashSet();

        for (int i = 0; i < len; i++) {
            end_set.add(end_sub.charAt(i));
        }
        return end_set;
    }

    public Set setOfLongestSubstring(String s) {
        int len = s.length();

        Set sub_set = new HashSet();
        String temp_s;

        for (int i = 1; i < len + 1; i++) {
            temp_s = s.substring(0, i);

            if (i == 1) {
                sub_set.add(s.charAt(0));
                continue;
            }

            String sub_s = s.substring(0, i - 1);

            if (LongestOnTheEnd(sub_s, sub_set.size())) {
                sub_set = EndSet(temp_s, sub_set.size() + 1);
            }
        }

        return sub_set;
    }


    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        return setOfLongestSubstring(s).size();
    }
}

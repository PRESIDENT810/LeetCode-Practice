import java.util.*;
import java.math.*;

class main {
    public static void main(String[] args) {
        Solution3 solu = new Solution3();
        int result = solu.lengthOfLongestSubstring("wobgrovw");
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

        if (len == 1) {
            Set crt_set = new HashSet();
            crt_set.add(s.charAt(0));
            return crt_set;
        }

        String sub_s = s.substring(0, len - 1);
        Set sub_set = setOfLongestSubstring(sub_s);

        if (LongestOnTheEnd(sub_s, sub_set.size())) {
            sub_set = EndSet(s, sub_set.size() + 1);
        }

        if (sub_set.contains(s.charAt(len - 1))) {
            return sub_set;
        } else {
            if (LongestOnTheEnd(sub_s, sub_set.size())) {
//                sub_set.add(s.charAt(len-1));
                return sub_set;
            } else return sub_set;
        }
    }


    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        return setOfLongestSubstring(s).size();
    }
}

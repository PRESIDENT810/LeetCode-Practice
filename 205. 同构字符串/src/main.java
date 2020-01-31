import java.util.*;

public class main {
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map map1 = new HashMap();
        Map map2 = new HashMap();

        if (s.length() != t.length()) return false;

        int len = s.length();
        char c1, c2;

        for (int i = 0; i < len; i++) {
            c1 = s.charAt(i);
            c2 = t.charAt(i);

            if (map1.containsKey(c1)) {
                if ((char) map1.get(c1) != c2) return false;
            } else if (map2.containsKey(c2)) {
                if ((char) map2.get(c2) != c1) return false;
            } else {
                map1.put(c1, c2);
                map2.put(c2, c1);
            }
        }
        return true;
    }
}
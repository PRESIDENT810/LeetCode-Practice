import java.util.*;

public class main {
}

class Solution205 {
    public boolean isIsomorphic(String s, String t) {

        int len = s.length();

        int[] map1 = new int[100];
        int[] map2 = new int[100];

        int c1, c2;

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        for (int i = 0; i < len; i++) {
            c1 = arr1[i]-' '+1;
            c2 = arr2[i]-' '+1;

            if (map1[c1] != 0) {
                if (map1[c1] != c2) return false;
            }
            else if (map2[c2] != 0) {
                if (map2[c2] != c1) return false;
            }
            else {
                map1[c1] = c2;
                map2[c2] = c1;
            }

        }
        return true;
    }
}
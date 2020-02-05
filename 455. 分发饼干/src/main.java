import java.util.*;

public class main {
    public static void main(String args[]){
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,1};
        System.out.print(new Solution455().findContentChildren(arr1, arr2));
    }
}

class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int size;
        int ans = 0;
        int ptr = g.length - 1;

        for (int i = 0; i < s.length; i++) {
            size = s[s.length - 1 - i];

            while (g[ptr] > size) {
                ptr--;
                if (ptr == 0) {
                    if (g[0] >= size) return ans;
                    else {ans++; return ans;}
                }
            }
            ans++;
            if (ptr == 0) break;
            ptr--;
        }
        return ans;
    }
}
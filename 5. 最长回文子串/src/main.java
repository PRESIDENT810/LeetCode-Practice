public class main {
    public static void main(String args[]) {
        System.out.print(new Solution5().longestPalindrome("babab"));
    }
}

class Solution5 {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        char[] arr = s.toCharArray();
        int n = s.length();

        boolean[][] table = new boolean[n][n];

        for (int height = 0; height < n; height++) { // iterate x ptr
            for (int x = 0; x < n; x++) { // iterate y ptr
                if (x + height > n - 1) continue;

                if (height == 0) table[x][x + height] = true;
                else {
                    boolean eq = arr[x] == arr[x + height];
                    if (height == 1) table[x][x + height] = eq;
                    else table[x][x + height] = eq && table[x + 1][x + height - 1];
                }
            }
        }

        int max_len = 0;
        int start = 0;
        int end = 0;

        for (int height = 0; height < n; height++) { // iterate x ptr
            for (int x = 0; x < n; x++) { // iterate y ptr
                if (x + height > n - 1) continue;

                if (table[x][x + height] && height > max_len) {
                    start = x;
                    end = x + height;
                    max_len = height;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
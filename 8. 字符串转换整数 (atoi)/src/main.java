public class main {
    public static void main(String args[]) {
        System.out.print(new Solution8().myAtoi("0-1"));
    }
}

class Solution8 {
    public int myAtoi(String str) {
        char[] arr = str.toCharArray();
        int sign = 1;
        boolean start = false;
        long ans = 0;

        for (char c : arr) {
            if (c == '-' && !start) {start = true; sign = -1; continue;}
            if (c == '+' && !start) {start = true; continue;}

            if (c-'0' < 0 || c-'9' > 0) {
                if (start) break;
                else if (c == ' ') continue;
                else return (int) ans;
            }
            else {
                ans = ans*10 + sign* ((int) c-'0');
                start = true;
            }

            if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) ans;
    }
}

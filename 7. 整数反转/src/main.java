import java.util.*;


public class main {
    public static void main(String args[]) {
        Solution7 solu = new Solution7();
        int result = solu.reverse(1534236469);
        System.out.println(result);
    }
}

class Solution7 {
    public int reverse(int x) {
        if (x == -2147483648) return 0;

        if (x < 0) {
            int ans = reverse(-1 * x);
            if (ans <= -1 * Math.pow(2, 31)) return 0;
            return -1 * ans;
        }

        int reverse = 0;

        while (x>=10){
            if (reverse > 214748364 || (reverse==214748364 && x%10>=8)) return 0;
            reverse = reverse*10+x%10;
            x = (int) x/10;
        }
        if (reverse > 214748364 || (reverse==214748364 && x%10>=8)) return 0;

        reverse = reverse*10+x;

        return reverse;
    }
}

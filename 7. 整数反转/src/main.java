import java.util.*;


public class main {
    public static void main(String args[]) {
        Solution7 solu = new Solution7();
        int result = solu.reverse(-2147483648);
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

        int ans = 0;
        Stack<Integer> stack = new Stack<Integer>();

        while (x >= 10) {
            stack.push(x % 10);
            x = (int) x / 10;
        }

        stack.push(x);

        int power = 0;

        while (!stack.empty()) {
            ans += stack.pop() * Math.pow(10, power);
            power += 1;
        }

        if (ans >= Math.pow(2, 31) - 1) return 0;

        return ans;
    }
}
